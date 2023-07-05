;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62998)
(include sci.sh)
(use Main)
(use Styler)
(use Str)
(use User)
(use System)

(public
	p2InitCode 0
)

(instance p2InitCode of Code
	(properties)

	(method (doit &tmp temp0)
		(Font 1 640 480) ; SetFontRes
		(= gUserFont 50)
		(= gSmallFont 50)
		(Lock rsSCRIPT 62996)
		(= gPlayback (ScriptID 62996 0)) ; playback
		((ScriptID 63025) init:) ; realCH1VMDTable
		((ScriptID 63026) init:) ; realCH2VMDTable
		((ScriptID 63027) init:) ; realCH3VMDTable
		((ScriptID 63028) init:) ; realCH4VMDTable
		((ScriptID 63029) init:) ; realCH5VMDTable
		(User canInput: 0)
		(if (DoSound sndGET_AUDIO_CAPABILITY)
			(= gMsgType 2)
			(DoAudio 12 0) ; AudMixCheck
			(DoAudio audRATE 22050)
			(DoAudio 10 16) ; AudBits
		else
			(= gMsgType 1)
		)
		(Styler divisions: 20)
		(= global206 15)
		(= gVersion (Str with: {001.0.00}))
		(= global204 (DoSound sndGET_POLYPHONY))
		(= global203 0)
		(= gEatMice 2)
		(SetPalStyleRange 0 103)
		(DisposeScript 62998)
	)
)

