;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 558)
(include sci.sh)
(use Main)
(use GloryWindow)
(use n814)
(use Print)
(use IconBar)
(use Inventory)
(use System)

(public
	glorySpells 0
)

(procedure (localproc_0)
	(gMessager say: 15 0 0 1 0 558) ; "That spell is not useful here."
)

(class QG1SpellItem of InvI
	(properties
		view 992
		signal 67
		modNum 558
		amount 0
		cost 0
	)

	(method (select)
		(if (super select: &rest)
			(self doVerb: 4)
			(return 0)
		)
	)

	(method (doVerb theVerb &tmp [temp0 10] [temp10 60])
		(if (== theVerb 1) ; Look
			(Message msgGET 558 noun 0 0 1 @temp0)
			(Message msgGET 558 16 0 0 1 @temp10) ; "You possess the %s. Your expertise is %d. You will use %d Magic Points each time you cast this spell."
			(Print
				font: gUserFont
				mode: 1
				width: (if (== noun 4) 200 else 180)
				addTextF: @temp10 @temp0 amount cost
				init:
			)
		)
		(super doVerb: theVerb)
	)
)

(instance glorySpells of Inv
	(properties
		normalHeading 9
		empty 27
	)

	(method (init)
		(if (& global191 $0001)
			(openSpell owner: gEgo amount: [gEgoStats 17] cost: global177) ; openSpell
		)
		(if (& global191 $0002)
			(detectMagicSpell
				owner: gEgo
				amount: [gEgoStats 18] ; detectSpell
				cost: global178
			)
		)
		(if (& global191 $0004)
			(triggerSpell owner: gEgo amount: [gEgoStats 19] cost: global179) ; triggerSpell
		)
		(if (& global191 $0008)
			(dazzleSpell owner: gEgo amount: [gEgoStats 20] cost: global180) ; dazzleSpell
		)
		(if (& global191 $0010)
			(zapSpell owner: gEgo amount: [gEgoStats 21] cost: global181) ; zapSpell
		)
		(if (& global191 $0020)
			(calmSpell owner: gEgo amount: [gEgoStats 22] cost: global182) ; calmSpell
		)
		(if (& global191 $0040)
			(flameDartSpell
				owner: gEgo
				amount: [gEgoStats 23] ; flameDartSpell
				cost: global183
			)
		)
		(if (& global191 $0080)
			(fetchSpell owner: gEgo amount: [gEgoStats 24] cost: global184) ; fetchSpell
		)
		(self
			window: spellWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
			add:
				openSpell
				detectMagicSpell
				triggerSpell
				dazzleSpell
				zapSpell
				calmSpell
				flameDartSpell
				fetchSpell
				invLook
				invSelect
				ok
				invHelp
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #init
			state: 2048
		)
	)

	(method (showSelf &tmp temp0)
		(Platform 0 4 3 -1)
		(super showSelf:)
		(self dispose: release:)
		(DisposeScript 558)
	)
)

(instance spellWin of GloryWindow
	(properties
		yOffset 28
	)

	(method (open)
		(invLook nsLeft: (- (/ (- (self right:) (self left:)) 2) 60))
		(+= top 24)
		(+= bottom 25)
		(super open:)
	)
)

(instance openSpell of QG1SpellItem
	(properties
		noun 12
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(glorySpells hide:)
			(cond
				((& global191 $0100)
					(localproc_0)
				)
				((not (CastSpell 17)))
				(
					(OneOf
						gCurRoomNum
						10
						13
						15
						16
						29
						30
						31
						41
						65
						67
						73
						76
						82
						83
						84
						91
						93
						94
						96
						97
						141
					)
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_3)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(return 1)
				)
				(else
					(CastArea 51)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance detectMagicSpell of QG1SpellItem
	(properties
		loop 1
		noun 6
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(glorySpells hide:)
			(cond
				((& global191 $0200)
					(localproc_0)
				)
				((not (CastSpell 18)))
				(
					(OneOf
						gCurRoomNum
						10
						13
						14
						15
						22
						29
						30
						31
						55
						58
						65
						67
						73
						76
						77
						78
						82
						83
						84
						91
						93
						94
						96
						97
						141
					)
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_2)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(return 1)
				)
				(else
					(CastArea 50)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance triggerSpell of QG1SpellItem
	(properties
		loop 2
		noun 17
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(glorySpells hide:)
			(cond
				((& global191 $0400)
					(localproc_0)
				)
				((not (CastSpell 19)))
				((OneOf gCurRoomNum 13 58 15 29 30 31 65 73 82 83 91 96 97 141)
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_M)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(return 1)
				)
				(else
					(CastArea 77)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance dazzleSpell of QG1SpellItem
	(properties
		loop 4
		noun 5
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(glorySpells hide:)
			(cond
				((& global191 $0800)
					(localproc_0)
				)
				((not (CastSpell 20)))
				(
					(OneOf
						gCurRoomNum
						13
						14
						15
						16
						29
						30
						31
						38
						40
						54
						55
						58
						65
						67
						73
						76
						77
						78
						82
						83
						84
						91
						93
						94
						96
						97
						141
						11
						12
						17
						18
						19
						23
						24
						25
						26
						33
						34
						35
						36
						42
						43
						44
						51
						52
						56
						57
						61
						62
						63
						69
						71
						72
						74
						75
						79
						80
						81
						85
						86
						92
					)
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_N)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(return 1)
				)
				(else
					(CastArea 78)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance zapSpell of QG1SpellItem
	(properties
		loop 3
		noun 18
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(glorySpells hide:)
			(cond
				((& global191 $1000)
					(localproc_0)
				)
				((not (CastSpell 21)))
				(
					(OneOf
						gCurRoomNum
						13
						29
						30
						31
						65
						91
						96
						97
						141
						11
						12
						17
						18
						19
						23
						24
						25
						26
						33
						34
						35
						36
						42
						43
						44
						51
						52
						56
						57
						61
						62
						63
						69
						71
						72
						74
						75
						79
						80
						81
						85
						86
						92
					)
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_O)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(return 1)
				)
				(else
					(CastArea 79)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance calmSpell of QG1SpellItem
	(properties
		loop 5
		noun 2
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(glorySpells hide:)
			(cond
				((& global191 $2000)
					(localproc_0)
				)
				((not (CastSpell 22)))
				(
					(OneOf
						gCurRoomNum
						10
						13
						14
						15
						29
						30
						31
						58
						65
						67
						73
						84
						91
						93
						94
						96
						97
						141
						11
						12
						17
						18
						19
						23
						24
						25
						26
						33
						34
						35
						36
						42
						43
						44
						51
						52
						56
						57
						61
						62
						63
						69
						71
						72
						74
						75
						79
						80
						81
						85
						86
						92
					)
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_P)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(return 1)
				)
				(else
					(CastArea 80)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance flameDartSpell of QG1SpellItem
	(properties
		loop 6
		cursor 948
		noun 4
	)

	(method (select)
		(gGame setCursor: 948)
		(super select: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(glorySpells hide:)
			(cond
				((& global191 $4000)
					(localproc_0)
				)
				((not (CastSpell 23)))
				(else
					((gTheIconBar at: 6) message: 81 cursor: 948)
					(gTheIconBar curIcon: (gTheIconBar at: 6))
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fetchSpell of QG1SpellItem
	(properties
		loop 7
		noun 7
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; Do
			(glorySpells hide:)
			(cond
				((& global191 $8000)
					(localproc_0)
				)
				((not (CastSpell 24)))
				((OneOf gCurRoomNum 13 15 16 29 30 31 54 65 73 91 96 97 141)
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_R)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(return 1)
				)
				(else
					(CastArea 82)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance invLook of IconI
	(properties
		view 991
		loop 2
		cel 0
		cursor 941
		message 1
		signal 129
		noun 9
		modNum 558
		helpVerb 9
	)
)

(instance invSelect of IconI
	(properties
		view 991
		loop 0
		cel 0
		cursor 942
		noun 14
		modNum 558
		helpVerb 9
	)
)

(instance invHelp of IconI
	(properties
		view 991
		loop 1
		cel 0
		cursor 949
		message 9
		noun 8
		modNum 558
		helpVerb 9
	)

	(method (show)
		(super show:)
		(DrawCel 991 7 0 (+ nsLeft (CelWide view loop cel)) nsTop -1)
	)
)

(instance ok of IconI
	(properties
		view 991
		loop 3
		cel 0
		cursor 999
		signal 67
		noun 10
		modNum 558
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(glorySpells hide:)
			(Platform 0 4 2 -1)
			(return)
		)
	)
)

