;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64896)
(include sci.sh)
(use Main)
(use Str)
(use Array)
(use System)

(public
	Face 0
	FadeToBlack 1
	GetTextWidth 3
	GetTextHeight 4
	MakeMessageText 5
	IsStringObject 6
	StringDispose 7
	LockNLoad 8
	UnlockNUnload 9
)

(procedure (LockNLoad nResType args &tmp i nRes)
	(= nRes (Max 0 (- argc 1)))
	(for ((= i 0)) (< i nRes) ((++ i))
		(if (not (ResCheck nResType [args i]))
			(PrintDebug
				{Resource type: %d num %d not found in LockNLoad.}
				nResType
				[args i]
			)
		else
			(PrintDebug {Locking ResType: %d, num: %d} nResType [args i])
			(Load nResType [args i])
			(Lock nResType [args i] 1)
		)
	)
)

(procedure (UnlockNUnload nResType args &tmp i nRes)
	(= nRes (Max 0 (- argc 1)))
	(for ((= i 0)) (< i nRes) ((++ i))
		(if (not (ResCheck nResType [args i]))
			(PrintDebug
				{Resource type: %d num %d not found in LockNLoad.}
				nResType
				[args i]
			)
		else
			(PrintDebug {Unlocking ResType: %d, num: %d} nResType [args i])
			(Lock nResType [args i] 0)
			(UnLoad nResType [args i])
		)
	)
)

(procedure (IsStringObject oString)
	(if (not oString)
		(PrintDebug {error in call of IsStringObject})
		(return 0)
	)
	(if (== oString (KString 9 oString)) ; StrGetData
		(return 0)
	else
		(return 1)
	)
)

(procedure (StringDispose oString)
	(if oString
		(if (IsStringObject oString)
			(oString dispose:)
		else
			(KString 4 oString) ; StrFree
		)
	)
)

(procedure (GetTextWidth strText nFont nMaxWidth &tmp oTextBox nWidth)
	(if (< argc 3)
		(PrintDebug {illegal call of GetTextWidth. djm gendialg.sc})
		(return 0)
	)
	(= oTextBox (IntArray new: 4))
	(Text 0 (oTextBox data:) (KString 9 strText) nFont nMaxWidth 1) ; TextSize, StrGetData
	(= nWidth (+ (oTextBox at: 2) 1))
	(oTextBox dispose:)
	(return nWidth)
)

(procedure (GetTextHeight strText nFont nMaxWidth &tmp oTextBox nHeight)
	(if (< argc 3)
		(PrintDebug {illegal call of GetTextWidth. djm gendialg.sc})
		(return 0)
	)
	(= oTextBox (IntArray new: 4))
	(Text 0 (oTextBox data:) (KString 9 strText) nFont nMaxWidth 1) ; TextSize, StrGetData
	(= nHeight (+ (oTextBox at: 3) 1))
	(oTextBox dispose:)
	(return nHeight)
)

(procedure (MakeMessageText nN nV nC nS nM &tmp noun verb case seq module oBuf)
	(if (< argc 1)
		(= noun 0)
	else
		(= noun nN)
	)
	(if (< argc 2)
		(= verb 0)
	else
		(= verb nV)
	)
	(if (< argc 3)
		(= case 0)
	else
		(= case nC)
	)
	(if (< argc 4)
		(= seq 1)
	else
		(= seq nS)
	)
	(if (< argc 5)
		(= module gCurRoomNum)
	else
		(= module nM)
	)
	(= oBuf (Str newWith: 4000 {}))
	(if (not (Message msgGET module noun verb case seq))
		(PrintDebug
			{MakeMessageText: No message found m:%hu n:%d v:%d c:%d s:%d}
			module
			noun
			verb
			case
			seq
		)
		(return 0)
	)
	(Message msgGET module noun verb case seq (oBuf data:))
	(return oBuf)
)

(procedure (Face who theObjOrX theY whoCares &tmp theHeading lookX lookY whoToCue)
	(= whoToCue 0)
	(if (not (> argc 3))
		(= lookX (theObjOrX x:))
		(= lookY (theObjOrX y:))
		(if (== argc 3)
			(= whoToCue theY)
		)
	else
		(= lookX theObjOrX)
		(= lookY theY)
		(if (== argc 4)
			(= whoToCue whoCares)
		)
	)
	(= theHeading (GetAngle (who x:) (who y:) lookX lookY))
	(who setHeading: theHeading whoToCue)
)

(procedure (FadeToBlack bFadeOut step whoToCue bAllColors &tmp i nInc nLastColor entirePalette)
	(if (or (< argc 2) (== step 0))
		(= nInc 1)
	else
		(= nInc step)
	)
	(if (>= argc 4)
		(= entirePalette bAllColors)
	else
		(= entirePalette 0)
	)
	(if (or (== argc 0) (== bFadeOut 1))
		(for ((= i 100)) (> i 0) ((-= i nInc))
			(if entirePalette
				(Palette 2 0 235 i) ; PalIntensity
			else
				(Palette 2 0 47 i) ; PalIntensity
				(Palette 2 66 204 i) ; PalIntensity
			)
			(FrameOut)
		)
		(if entirePalette
			(Palette 2 0 235 0) ; PalIntensity
		else
			(Palette 2 0 47 0) ; PalIntensity
			(Palette 2 66 204 0) ; PalIntensity
		)
		(FrameOut)
	else
		(for ((= i 0)) (< i 100) ((+= i nInc))
			(if entirePalette
				(Palette 2 0 235 i) ; PalIntensity
			else
				(Palette 2 0 47 i) ; PalIntensity
				(Palette 2 66 204 i) ; PalIntensity
			)
			(FrameOut)
		)
		(if entirePalette
			(Palette 2 0 235 100) ; PalIntensity
		else
			(Palette 2 0 47 100) ; PalIntensity
			(Palette 2 66 204 100) ; PalIntensity
		)
		(FrameOut)
	)
	(if (and (>= argc 3) whoToCue)
		(whoToCue cue:)
	)
	(DisposeScript 64896)
)

