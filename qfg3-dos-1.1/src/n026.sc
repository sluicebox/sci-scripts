;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use GloryWindow)
(use Interface)
(use Print)
(use Dialog)
(use IconBar)
(use DCIcon)
(use GameControls)
(use Motion)
(use System)

(public
	EgoDead 0
)

(local
	local0 = 400
	local1
	local2
	local3
	local4
	[local5 10]
	[local15 10]
	[local25 5]
	[local30 20]
	local50
	local51
	local52
	local53
	local54
	local55
	local56
	[local57 30]
)

(procedure (EgoDead param1 param2 param3 param4 param5)
	(HandsOff)
	(if (not (IsFlag 140))
		(if (IsFlag 162)
			(return 0)
		else
			(SetFlag 162)
		)
	)
	(gGame setCursor: gNormalCursor 1)
	(= local54 0)
	(= local55 152)
	(if (>= argc 1)
		(= local1 param1)
		(if (>= argc 2)
			(if param2
				(= local2 param2)
			else
				(= local2 gCurRoomNum)
			)
			(if (>= argc 3)
				(= local53 param3)
				(if (>= argc 4)
					(= local54 param4)
					(if (== argc 5)
						(= local55 param5)
					)
				)
			else
				(= local53 937)
			)
		else
			(= local2 gCurRoomNum)
			(= local53 937)
		)
	else
		(= local53 937)
		(= local2 26)
		(= local1 1)
	)
	(deathViewIcon view: local53)
	(= local56 (+ (CelWide (deathViewIcon view:) (deathViewIcon loop:)) 10))
	(= local50 (- 200 local56))
	(= local51
		(+ (* (+ (/ (Message msgSIZE local2 0 63 local1 1) (/ local50 6)) 4) 9) 5)
	)
	(if
		(>
			(= local52
				(+ (CelHigh (deathViewIcon view:) (deathViewIcon loop:)) 25)
			)
			local51
		)
		(= local51 local52)
	)
	(= local3 (gLongSong number:))
	(gSounds eachElementDo: #fade 0 1 5 1)
	(DIcon state: (| (DIcon state:) $0004))
	(SetCursor -2)
	(return (localproc_0))
)

(procedure (localproc_0)
	(Message msgGET 26 1 0 3 1 @local5) ; "Restore"
	(Message msgGET 26 1 0 4 1 @local15) ; "Restart"
	(Message msgGET 26 1 0 5 1 @local25) ; "Quit"
	(Message msgGET 26 1 0 6 1 @local30) ; "See the Message"
	(repeat
		(switch local4
			(1
				(if (IsFlag 140)
					(ClearFlag 140)
					(gMessager say: 0 63 local1 3 0 local2)
					(if (IsObject deathViewIcon)
						(deathViewIcon dispose:)
					)
					(gLongSong number: local3 setLoop: 1 play:)
					(break)
				else
					(Palette palSET_INTENSITY 0 255 100)
					(gGame restart:)
				)
			)
			(2
				(if (IsFlag 140)
					(ClearFlag 140)
					(gMessager say: 0 63 local1 3 0 local2)
					(if (IsObject deathViewIcon)
						(deathViewIcon dispose:)
					)
					(gLongSong number: local3 setLoop: 1 play:)
					(break)
				else
					(Palette palSET_INTENSITY 0 255 100)
					(gGame restore:)
				)
			)
			(3
				(if (IsFlag 140)
					(ClearFlag 140)
					(gMessager say: 0 63 local1 3 0 local2)
					(deathViewIcon dispose:)
					(gLongSong number: local3 setLoop: 1 play:)
					(break)
				)
				(= gQuit 1)
				(break)
			)
			(else
				(cond
					((== local53 937)
						(deathViewIcon cel: 0 cycler: (End new:))
					)
					(local54
						(deathViewIcon cycler: (local54 new:))
					)
				)
				(if (deathViewIcon cycler:)
					((deathViewIcon cycler:) init: deathViewIcon)
				)
				(gLongSong number: local55 setLoop: 1 setVol: 80 play:)
				(myPrint
					addIcon: 935 1 0 5 0
					addIcon: deathViewIcon 0 0 2 22
					width: local50
					font: 0
					addText: 0 63 local1 1 local56 22 local2
					init:
				)
			)
		)
		(gLongSong stop:)
		(quest init: show: dispose:)
	)
)

(instance deathViewIcon of DCIcon
	(properties)

	(method (init))

	(method (draw &tmp [temp0 30])
		(Message msgGET local2 0 63 local1 2 @temp0)
		(Display @temp0 dsCOORD 6 6 dsALIGN alCENTER dsCOLOR 42 dsFONT 123 dsWIDTH 200)
		(Display @temp0 dsCOORD 5 6 dsALIGN alCENTER dsCOLOR 41 dsFONT 123 dsWIDTH 200)
		(super draw:)
	)
)

(instance myPrint of Print
	(properties)

	(method (addIcon param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(if (not dialog)
			(= dialog (myDialog new:))
		)
		(if (> argc 3)
			(= temp0 param4)
			(= temp1 param5)
		else
			(= temp0 (= temp1 0))
		)
		(if (IsObject param1)
			(dialog
				add: (param1 setSize: moveTo: (+ temp0 4) (+ temp1 4) yourself:)
				setSize:
			)
		else
			(dialog
				add:
					((DIcon new:)
						view: param1
						loop: param2
						cel: param3
						setSize:
						moveTo: (+ temp0 4) (+ temp1 4)
						yourself:
					)
				setSize:
			)
		)
	)

	(method (showSelf &tmp temp0 temp1 temp2 temp3 temp4)
		(if saveCursor
			(gGame setCursor: 999)
		)
		(if (not dialog)
			(= dialog myDialog)
			(myDialog init:)
		)
		(dialog
			window: (if window window else gSystemWindow)
			name: {PODialog}
			caller: self
		)
		(dialog text: title time: ticks setSize:)
		(dialog center:)
		(= temp3
			(if (== x -1)
				(dialog nsLeft:)
			else
				x
			)
		)
		(= temp4
			(if (== y -1)
				(dialog nsTop:)
			else
				y
			)
		)
		(dialog moveTo: temp3 temp4)
		(= temp1 (GetPort))
		(dialog open: (if title 4 else 0) 15)
		(if modeless
			(= gModelessPort (GetPort))
			(SetPort temp1)
			(= gModelessDialog dialog)
		else
			(gSounds pause: 1)
			(cond
				((not (= temp0 first))
					(if
						(and
							(= temp0 (dialog firstTrue: #checkState 1))
							(not (dialog firstTrue: #checkState 2))
						)
						(temp0 state: (| (temp0 state:) $0002))
					)
				)
				((not (IsObject temp0))
					(= temp0 (dialog at: temp0))
				)
			)
			(= retValue (dialog doit: temp0))
			(SetPort temp1)
			(cond
				((== retValue -1)
					(= retValue 0)
				)
				((and (IsObject retValue) (retValue isKindOf: DButton))
					(= retValue (retValue value:))
				)
				((not (dialog theItem:))
					(= retValue 1)
				)
			)
			(if saveCursor
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
			(dialog dispose:)
			(return retValue)
		)
	)
)

(instance myDialog of Dialog
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(= gGameTime (+ gTickOffset (GetTime)))
		(= temp2 0)
		(self eachElementDo: #init)
		(if theItem
			(theItem select: 0)
		)
		(= theItem
			(if (and argc param1)
				param1
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem
			(theItem select: 1)
		)
		(if (not theItem)
			(= eatTheMice gEatMice)
			(= lastTicks (GetTime))
		else
			(= eatTheMice 0)
		)
		(= temp1 0)
		(while (not temp1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(if (< (-- local0) 0)
				(= local0 400)
				(return temp1)
			)
			(self eachElementDo: #cycle)
			(= temp0 ((Event new:) localize:))
			(if eatTheMice
				(-- eatTheMice)
				(if (== (temp0 type:) 1)
					(temp0 type: 0)
				)
				(while (== lastTicks (GetTime))
				)
				(= lastTicks (GetTime))
			)
			(= temp1 (self handleEvent: temp0))
			(temp0 dispose:)
			(if (self check:)
				(break)
			)
			(if (== temp1 -2)
				(= temp1 0)
				(EditControl theItem 0)
				(break)
			)
			(Wait 1)
		)
		(return temp1)
	)
)

(instance quest of GameControls
	(properties)

	(method (init)
		(gGame setCursor: 999)
		((= window (GloryWindow new:))
			top: 50
			left: 85
			bottom: 125
			right: 235
			priority: 15
			yourself:
		)
		(self add: titleIcon backIcon restartIcon restoreIcon quitIcon)
		(super init: &rest)
	)
)

(instance titleIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 0
		signal 4
		maskView 361
		maskLoop 3
	)

	(method (show &tmp [temp0 20])
		(Message msgGET 26 1 0 7 1 @temp0) ; "Select which ?"
		(Display @temp0 dsCOORD 5 3 dsCOLOR 17)
	)
)

(instance backIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 15
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local4 0)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local30 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local30 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance restoreIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 45
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local4 2)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local5 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local5 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance restartIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 30
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local4 1)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local15 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local15 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance quitIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 60
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local4 3)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local25 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local25 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

