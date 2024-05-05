;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Interface)
(use n940)
(use File)
(use Actor)
(use System)

(public
	writeCast 0
)

(local
	[fileName 32]
)

(procedure (GetSaveSetupName theName)
	(if (not (PrintD {File name [.set]} 101 41 theName 40))
		(return 0)
	)
	(StrCat theName {.set})
	(return 1)
)

(instance file of File
	(properties)
)

(instance writeCast of Code
	(properties)

	(method (init &tmp rc [str 40])
		(file name: @fileName)
		(if (not (GetSaveSetupName (file name:)))
			(return)
		)
		(gGame setCursor: gWaitCursor)
		(if (not (file open: 2))
			(Print
				(Format @str {Error opening file %s} (file name:))
				81
				{Cancel}
			)
			(gGame setCursor: gNormalCursor)
			(return)
		)
		(gGame setCursor: gWaitCursor)
		(file writeString: {; Tester 2.33} {\0d\n\0d\n})
		(file
			writeString:
				(Format @str {; picture %d\0d\n\0d\n} (gCurRoom curPic:))
		)
		(if global61
			(file writeString: (Format @str {; palette %d\0d\n\0d\n} global61))
		)
		(gCast eachElementDo: #perform self)
		(gAddToPics eachElementDo: #perform self)
		(file close:)
		(gGame setCursor: gNormalCursor)
	)

	(method (doit obj &tmp isActor nSignalBits [str 150] [signalStr 100])
		(= isActor (obj isKindOf: Actor))
		(file
			writeString:
				(Format
					@str
					{(instance %s of %s\0d\n\t(properties\0d\n\t\tview\t\t\t%d\0d\n\t\tloop\t\t\t%d\0d\n\t\tcel\t\t\t%d\0d\n}
					(obj name:)
					{Actor}
					(obj view:)
					(obj loop:)
					(obj cel:)
				)
		)
		(if (obj palette:)
			(file
				writeString:
					(Format @str {\t\tpalette\t\t%d\0d\n} (obj palette:))
			)
		)
		(file
			writeString:
				(Format
					@str
					{\t\tx\t\t\t\t%d\0d\n\t\ty\t\t\t\t%d\0d\n}
					(obj x:)
					(obj y:)
				)
		)
		(if (obj z:)
			(file
				writeString: (Format @str {\t\tz\t\t\t\t%d\0d\n} (obj z:))
			)
		)
		(if (and isActor (obj cycleSpeed:))
			(file
				writeString:
					(Format
						@str
						{\t\tcycleSpeed\t%d\0d\n}
						(obj cycleSpeed:)
					)
			)
		)
		(if (and (obj isKindOf: Actor) (obj moveSpeed:))
			(file
				writeString:
					(Format @str {\t\tmoveSpeed\t%d\0d\n} (obj moveSpeed:))
			)
		)
		(= signalStr 0)
		(= nSignalBits 0)
		(if (& (obj signal:) $0010)
			(file
				writeString:
					(Format @str {\t\tpriority\t\t%d\0d\n} (obj priority:))
			)
			(StrCat @signalStr {fixPriOn})
			(++ nSignalBits)
		)
		(if (and (obj isKindOf: Actor) (not (obj illegalBits:)))
			(file writeString: {\t\tillegalBits\t$0000\0d\n})
		)
		(if (& (obj signal:) $4000)
			(if nSignalBits
				(StrCat @signalStr { })
			)
			(StrCat @signalStr {ignrAct})
			(++ nSignalBits)
		)
		(if (& (obj signal:) $0004)
			(if nSignalBits
				(StrCat @signalStr { })
			)
			(StrCat @signalStr {notUpd})
			(++ nSignalBits)
		)
		(if nSignalBits
			(file writeString: {\t\tsignal\t\t})
			(if (> nSignalBits 1)
				(file writeString: {(| })
			)
			(file writeString: @signalStr)
			(if (> nSignalBits 1)
				(file writeString: {)})
			)
			(file writeString: {\0d\n})
		)
		(file writeString: {\t)\0d\n)\0d\n\0d\n})
	)
)

