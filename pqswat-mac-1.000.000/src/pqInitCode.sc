;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use PQEgo)
(use Print)
(use Talker)
(use User)
(use System)

(public
	pqInitCode 0
)

(instance pqInitCode of Code
	(properties)

	(method (doit &tmp [temp0 2])
		(= gUserFont 999)
		(User alterEgo: PQEgo canControl: 0 canInput: 0)
		(if (DoSound 1) ; sndGET_AUDIO_CAPABILITY
			(DoAudio 12 0) ; AudMixCheck
			(DoAudio audRATE 22050)
			(DoAudio 10 16) ; AudBits
		)
		(= gMsgType 2)
		(= gUseSortedFeatures 1)
		(= gScore 0)
		(gGame masterVolume: 15)
		(Print font: 999 back: 0 fore: 19 skip: 254)
		(Narrator back: 0 fore: 19 modeless: 2)
		(RemapColors 2 236 90) ; ByPercent
		(RemapColors 2 237 80) ; ByPercent
		(RemapColors 2 238 70) ; ByPercent
		(RemapColors 2 239 60) ; ByPercent
		(RemapColors 2 240 50) ; ByPercent
		(RemapColors 2 241 40) ; ByPercent
		(RemapColors 2 242 30) ; ByPercent
		(RemapColors 2 243 20) ; ByPercent
		(RemapColors 2 244 10) ; ByPercent
		(if (IsHiRes)
			(SetFlag 1)
			(Font 1 640 480) ; SetFontRes
		)
		(= global105 (DoSound 13)) ; sndGET_POLYPHONY
		(= gEatMice 2)
		(SetPalStyleRange 0 103)
		(= global402 (= global446 24))
		(= global401 (= global445 26))
	)
)

