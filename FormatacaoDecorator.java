public class FormatacaoDecorator implements IFormatacao {
    private final IFormatacao formatoDecorador;

    public FormatacaoDecorator(IFormatacao formato) {
        this.formatoDecorador = formato;
    }
}
