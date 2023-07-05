;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Styler)
(use Str)
(use Print)
(use User)
(use System)

(public
	gk2InitCode 0
)

(instance gk2InitCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(Font 1 640 480) ; SetFontRes
		(= gUserFont 50)
		(= gSmallFont 50)
		(Lock rsVIEW 999 1)
		(Lock rsVIEW 998 1)
		(Lock rsVIEW 996 1)
		(= temp1 (Str newWith: 16 {}))
		(User canControl: 0 canInput: 0)
		(if (DoSound sndGET_AUDIO_CAPABILITY)
			(= gMsgType 2)
			(DoAudio 12 0) ; AudMixCheck
			(DoAudio audRATE 22050)
			(DoAudio 10 16) ; AudBits
		else
			(= gMsgType 1)
		)
		(= gUseSortedFeatures 1)
		(Styler divisions: 20)
		(= gScore 0)
		(gGame masterVolume: 15)
		(Print font: 999 back: 0 fore: 255 skip: 254)
		(= global104 (DoSound sndGET_POLYPHONY))
		(if (FileIO fiEXISTS {classes})
			(= gDebugging 1)
		else
			(= gDebugging 0)
		)
		(temp1 dispose:)
		(= gEatMice 2)
		(SetPalStyleRange 0 103)
		(DisposeScript 25)
	)
)

