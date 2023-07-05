;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 740)
(include sci.sh)
(use Main)
(use LarryRoom)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm740 0
)

(local
	[local0 9] = [15 77 69 73 50 45 63 17 63]
	[local9 22] = [3 3 3 4 4 3 5 4 3 3 5 4 5 4 5 3 3 3 5 6 1 -1]
	local31
	local32 = -1
	local33 = 1
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44 = -1
	local45 = 40
	local46
	local47 = -1
	local48
	local49 = 7
	local50
	local51
	local52
	local53
)

(instance rm740 of LarryRoom
	(properties
		picture 740
		autoLoad 0
		noControls 1
	)

	(method (init)
		(SetPort 0 0 190 320 10 0)
		(gMenuBar hide: state: 0)
		(DrawPic 98)
		(super init: &rest)
		(cartoonProp init: hide:)
		(gEgo init: hide:)
		(gGlobalSound1 number: 740)
		(gGlobalSound1 loop: 1 play: showCartoon)
		(cond
			((== global100 740)
				(self setScript: scrollText)
			)
			((== global100 741)
				(self setScript: playMusicScr)
			)
			(else
				(self setScript: showCartoon)
			)
		)
		(gKeyDownHandler addToFront: self)
		(gGame setCursor: invCursor)
	)

	(method (handleEvent event)
		(if (& (event type:) evKEYBOARD)
			(event claimed: 1)
		)
	)

	(method (drawPic)
		(SetPort 0)
		(SetPort 0 0 200 320)
		(DrawPic picture 100)
	)

	(method (dispose)
		(if (gKeyDownHandler contains: self)
			(gKeyDownHandler delete: self)
		)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)
)

(instance cartoonProp of Prop
	(properties
		x 100
		y 20
		view 740
		priority 14
		signal 16
		cycleSpeed 9
	)
)

(instance fireWorks of Prop
	(properties
		view 789
	)
)

(instance scrollText of Script
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(gMenuBar draw:)
			(gMouseDownHandler delete: self)
			(= local43 1)
			(gGame setCursor: gWaitCursor)
		)
	)

	(method (changeState newState &tmp [temp0 120])
		(switch (= state newState)
			(0
				(= ticks 240)
			)
			(1
				(DrawPic 98 9)
				(if (!= (gGlobalSound1 number:) 741)
					(gGlobalSound1 number: 741 loop: 1 play:)
				)
				(gMouseDownHandler addToFront: self)
				(= cycles 2)
			)
			(2
				(= register 0)
				(= local32 -1)
				(= ticks 120)
			)
			(3
				(DrawPic 98 13)
				(self cue:)
			)
			(4
				(if (== (= local31 [local9 (++ local32)]) -1)
					(= next playMusicScr)
					(self dispose:)
				else
					(= local36 [local0 (Random 0 8)])
					(= local34 (/ (- 185 (* local31 24)) 2))
				)
				(self cue:)
			)
			(5
				(Message msgGET 740 0 0 0 (++ register) @temp0)
				(Display @temp0 dsALIGN alCENTER dsCOORD 0 local34 dsWIDTH 320 dsCOLOR local36 dsFONT 900)
				(= cycles 2)
			)
			(6
				(if local43
					(gMenuBar state: 1)
				)
				(= ticks (Max 220 (/ (* gTextSpeed (StrLen @temp0)) 2)))
			)
			(7
				(gMenuBar state: 0)
				(= cycles 2)
			)
			(8
				(DrawPic 98 (Random 11 14))
				(= state 3)
				(self cue:)
			)
		)
	)
)

(instance rangeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cartoonProp show:)
				(= local39 register)
				(self cue:)
			)
			(1
				(if (== local33 -1)
					(cartoonProp cel: (cartoonProp lastCel:) setCycle: Beg self)
				else
					(cartoonProp cel: 0 setCycle: End self)
				)
			)
			(2
				(= ticks 1)
			)
			(3
				(if (-- local39)
					(cartoonProp view: (+ (cartoonProp view:) local33))
					(= state 0)
				)
				(self cue:)
			)
			(4
				(= ticks (Max 1 (cartoonProp cycleSpeed:)))
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance loopRangeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local40 register)
				(= local38 (cartoonProp view:))
				(self cue:)
			)
			(1
				(cartoonProp view: local38)
				(self setScript: rangeScr self local37)
			)
			(2
				(= ticks 1)
			)
			(3
				(if (-- local40)
					(= state 0)
					(self cue:)
				else
					(self dispose:)
				)
			)
		)
	)

	(method (dispose)
		(if script
			(script caller: 0)
		)
		(super dispose:)
	)
)

(instance modifyPaletteScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local41 -1)
					(= register 100)
				else
					(= register 40)
				)
				(= ticks 10)
			)
			(1
				(cond
					((and (== local41 -1) (> register local45))
						(-- register)
						(-- state)
					)
					((and (== local41 1) (< register 100))
						(++ register)
						(-- state)
					)
				)
				(cond
					(local50
						(Palette palSET_INTENSITY 0 79 register)
						(Palette palSET_INTENSITY 120 255 register)
					)
					((not local46)
						(Palette palSET_INTENSITY 80 119 register)
					)
					(else
						(Palette palSET_INTENSITY 0 255 register)
					)
				)
				(= ticks local49)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance cartoonManagerScr of Script
	(properties)

	(method (cue)
		(switch (++ local44)
			(0
				(if (!= (showCartoon state:) 13)
					(if (cartoonProp script:)
						((cartoonProp script:) caller: 0)
						((cartoonProp script:) dispose:)
					)
					(showCartoon state: 10 cycles: 0 ticks: 0 register: 1)
					(cartoonProp hide:)
				)
				(showCartoon cue:)
			)
			(1
				(fireWorksScr register: 1)
			)
			(2
				(showCartoon state: 74 ticks: 0 cycles: 1)
				(if (cartoonProp script:)
					((cartoonProp script:) caller: 0)
					((cartoonProp script:) dispose:)
				)
				(cartoonProp hide: setCycle: 0)
			)
			(3
				(if (!= (showCartoon state:) 93)
					(if (cartoonProp script:)
						((cartoonProp script:) caller: 0)
						((cartoonProp script:) dispose:)
					)
					(showCartoon ticks: 0 cycles: 0 state: 95)
					(cartoonProp dispose:)
				)
				(showCartoon cue:)
			)
		)
	)
)

(instance showCartoon of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(= next scrollText)
				(= register 0)
				(= cycles 2)
			)
			(1
				(Load rsVIEW 740 741 742 743 744)
			)
			(2
				(gGlobalSound1 client: cartoonManagerScr)
				(= local33 -1)
				(= local41 -1)
				(gEgo setScript: modifyPaletteScr)
				(cartoonProp
					view: 744
					cycleSpeed: 9
					posn:
						(/ (- 320 (CelWide 740 0 0)) 2)
						(/ (- 190 (CelHigh 740 0 0)) 2)
					init:
					setScript: rangeScr self 5
				)
			)
			(3
				(cartoonProp hide:)
				(= ticks 10)
			)
			(4
				(UnLoad 128 740 741 742 743 744)
				(= cycles 2)
			)
			(5
				(Load rsVIEW 745 746)
				(= cycles 2)
			)
			(6
				(= local33 1)
				(cartoonProp
					view: 745
					posn: (Random 15 200) (Random 10 112)
					setScript: rangeScr self 2
				)
			)
			(7
				(cartoonProp hide:)
				(= ticks 10)
			)
			(8
				(UnLoad 128 745 746)
				(= cycles 2)
			)
			(9
				(Load rsVIEW 747 748 749 750 751 752)
				(= cycles 2)
			)
			(10
				(= local33 1)
				(cartoonProp
					view: 747
					cycleSpeed: 6
					posn: (Random 15 200) (Random 10 112)
					setScript: rangeScr self 6
				)
			)
			(11
				(cartoonProp hide:)
				(if register
					(= cycles 2)
				else
					(= ticks 10)
				)
			)
			(12
				(UnLoad 128 747 748 749 750 751 752)
				(= cycles 2)
			)
			(13
				(Load rsVIEW 753 754)
				(if register
					(= cycles 2)
				)
			)
			(14
				(cartoonProp
					view: 753
					cycleSpeed: 9
					posn: (Random 15 200) (Random 10 112)
					cel: 0
					show:
					setCycle: End self
				)
			)
			(15
				(= ticks 1)
			)
			(16
				(cartoonProp view: 754 cel: 0 setCycle: CT 4 1 self)
			)
			(17
				(= ticks (Max 1 (cartoonProp cycleSpeed:)))
			)
			(18
				(cartoonProp cel: 3)
				(= ticks (Max 1 (cartoonProp cycleSpeed:)))
			)
			(19
				(cartoonProp cel: 4)
				(= ticks (Max 1 (cartoonProp cycleSpeed:)))
			)
			(20
				(cartoonProp cel: 3)
				(= ticks (Max 1 (cartoonProp cycleSpeed:)))
			)
			(21
				(cartoonProp cel: 4)
				(= ticks (Max 1 (cartoonProp cycleSpeed:)))
			)
			(22
				(cartoonProp cel: 3)
				(= ticks (Max 1 (cartoonProp cycleSpeed:)))
			)
			(23
				(cartoonProp cel: 4)
				(= ticks (Max 1 (cartoonProp cycleSpeed:)))
			)
			(24
				(cartoonProp cel: 3)
				(= ticks (Max 1 (cartoonProp cycleSpeed:)))
			)
			(25
				(cartoonProp setCycle: End self)
			)
			(26
				(cartoonProp hide:)
				(= ticks (Max 1 (cartoonProp cycleSpeed:)))
			)
			(27
				(UnLoad 128 755 756)
				(= cycles 2)
			)
			(28
				(Load rsVIEW 755 756)
				(= cycles 2)
			)
			(29
				(= local33 1)
				(cartoonProp
					view: 755
					cel: 0
					posn: (Random 15 200) (Random 10 112)
					setScript: rangeScr self 2
				)
			)
			(30
				(cartoonProp hide:)
				(= ticks 10)
			)
			(31
				(UnLoad 128 753 754)
				(= cycles 2)
			)
			(32
				(Load rsVIEW 757 758 759 760 761)
				(= cycles 2)
			)
			(33
				(= local33 1)
				(cartoonProp
					view: 757
					posn: (Random 15 200) (Random 10 112)
					setScript: rangeScr self 5
				)
			)
			(34
				(cartoonProp hide:)
				(= ticks 10)
			)
			(35
				(UnLoad 128 757 758 759 760 761)
				(= cycles 2)
			)
			(36
				(Load rsVIEW 762 763 764)
				(= cycles 2)
			)
			(37
				(= local33 1)
				(cartoonProp
					view: 762
					posn: (Random 15 200) (Random 10 112)
					setScript: rangeScr self 3
				)
			)
			(38
				(cartoonProp hide:)
				(= ticks 10)
			)
			(39
				(UnLoad 128 762 763 764)
				(= cycles 2)
			)
			(40
				(if (> gHowFast 11)
					(fireWorks init: setScript: fireWorksScr)
				)
				(self cue:)
			)
			(41
				(Load rsVIEW 765 766 767)
				(= cycles 2)
			)
			(42
				(= local33 1)
				(cartoonProp
					view: 765
					posn: 45 105
					cycleSpeed: 4
					setScript: rangeScr self 2
				)
				(= register 4)
			)
			(43
				(cartoonProp view: 767 cel: 0 setCycle: CT 5 1 self)
			)
			(44
				(if (-- register)
					(cartoonProp view: 766 cel: 0 setCycle: End self)
					(= state 42)
				else
					(self cue:)
				)
			)
			(45
				(cartoonProp hide:)
				(= ticks 10)
			)
			(46
				(UnLoad 128 762 763 764)
				(= cycles 2)
			)
			(47
				(Load rsVIEW 768 769 770)
				(= cycles 2)
			)
			(48
				(= local33 1)
				(cartoonProp
					view: 768
					posn: 83 84
					cycleSpeed: 6
					setScript: rangeScr self 3
				)
			)
			(49
				(= ticks 1)
			)
			(50
				(cartoonProp view: 769 cel: 0 setScript: rangeScr self 2)
			)
			(51
				(= ticks 1)
			)
			(52
				(cartoonProp view: 769 cel: 0 setScript: rangeScr self 2)
			)
			(53
				(cartoonProp hide:)
				(= ticks 10)
			)
			(54
				(UnLoad 128 762 763 764)
				(= cycles 2)
			)
			(55
				(Load rsVIEW 771 772 773 774)
				(gCurRoom drawPic:)
				(= cycles 2)
			)
			(56
				(= local33 1)
				(cartoonProp
					view: 771
					cycleSpeed: (Max 0 (- 4 (* local48 2)))
					posn: 146 80
					setScript: rangeScr self 4
				)
			)
			(57
				(= ticks 1)
			)
			(58
				(cartoonProp view: 771 setScript: rangeScr self 4)
			)
			(59
				(= ticks 1)
			)
			(60
				(cartoonProp view: 771 setScript: rangeScr self 4)
			)
			(61
				(cartoonProp hide:)
				(= ticks 10)
			)
			(62
				(UnLoad 128 740 741 742 743 744)
				(= cycles 2)
			)
			(63
				(cartoonProp
					view: 775
					cel: 0
					show:
					posn: 209 109
					cycleSpeed: (Max 0 (- 9 (* local48 3)))
					setCycle: Fwd
				)
				(= ticks 300)
			)
			(64
				(cartoonProp setCycle: End self)
			)
			(65
				(cartoonProp hide:)
				(= ticks 10)
			)
			(66
				(UnLoad 128 775)
				(= cycles 2)
			)
			(67
				(Load rsVIEW 776 790)
				(= cycles 2)
			)
			(68
				(= local37 1)
				(cartoonProp
					view: 776
					posn: 105 111
					cycleSpeed: (Max 0 (- 9 (* local48 3)))
					setScript: loopRangeScr self 8
				)
			)
			(69
				(cartoonProp hide:)
				(= ticks 10)
			)
			(70
				(UnLoad 128 776)
				(= cycles 2)
			)
			(71
				(Load rsVIEW 778 779 780)
				(= cycles 2)
			)
			(72
				(= local33 1)
				(cartoonProp
					view: 778
					posn: 105 120
					cycleSpeed: (Max 0 (- 9 (* local48 3)))
					setScript: rangeScr self 3
				)
			)
			(73
				(cartoonProp hide:)
				(= ticks 10)
			)
			(74
				(UnLoad 128 778 779 780)
				(= state 54)
				(++ local48)
				(= cycles 2)
			)
			(75
				(Load rsVIEW 781 782)
				(= cycles 2)
			)
			(76
				(cartoonProp
					view: 781
					cycleSpeed: 9
					posn: (Random 15 200) (Random 10 112)
					setScript: rangeScr self 2
				)
			)
			(77
				(cartoonProp hide:)
				(= ticks 10)
			)
			(78
				(UnLoad 128 781 782)
				(= cycles 2)
			)
			(79
				(Load rsVIEW 783 784 785 786 787)
				(= cycles 2)
			)
			(80
				(cartoonProp
					view: 783
					cycleSpeed: 8
					posn: (Random 15 200) (Random 10 112)
					setScript: rangeScr self 5
				)
			)
			(81
				(cartoonProp hide:)
				(= ticks 10)
			)
			(82
				(UnLoad 128 783 784 785 786 787)
				(= cycles 2)
			)
			(83
				(Load rsVIEW 765 766 767)
				(gCurRoom drawPic:)
				(= cycles 2)
			)
			(84
				(= local33 -1)
				(cartoonProp
					view: 767
					posn: (Random 15 200) (Random 10 112)
					setScript: rangeScr self 3
				)
			)
			(85
				(cartoonProp hide:)
				(= ticks 10)
			)
			(86
				(UnLoad 128 765 766 767)
				(= cycles 2)
			)
			(87
				(Palette palSET_FROM_RESOURCE 740)
				(Load rsVIEW 740 741 742 743 744)
				(= cycles 2)
			)
			(88
				(= local33 1)
				(cartoonProp
					view: 740
					cycleSpeed: 9
					posn:
						(/ (- 320 (CelWide 740 0 0)) 2)
						(/ (- 190 (CelHigh 740 0 0)) 2)
					init:
					setScript: rangeScr self 5
				)
			)
			(89
				(cartoonProp hide:)
				(= ticks 10)
			)
			(90
				(UnLoad 128 740 741 742 743 744)
				(= cycles 2)
			)
			(91
				(Palette palSET_FROM_RESOURCE 740)
				(Load rsVIEW 792 793)
				(= cycles 2)
			)
			(92
				(= local33 1)
				(cartoonProp
					view: 792
					cycleSpeed: 14
					posn:
						(/ (- 320 (CelWide 740 0 0)) 2)
						(/ (- 190 (CelHigh 740 0 0)) 2)
					init:
					setScript: rangeScr self 2
				)
			)
			(93 0)
			(94
				(= local49 1)
				(= local45 40)
				(= local50 1)
				(gEgo setScript: modifyPaletteScr self)
			)
			(95
				(= cycles 2)
			)
			(96
				(= local50 0)
				(gGlobalSound1 client: self)
				(= local45 0)
				(= local46 1)
				(gEgo
					setScript:
						(modifyPaletteScr start: 1 register: 40 yourself:)
						self
				)
			)
			(97
				(cartoonProp dispose:)
				(DrawPic 98 100)
				(= cycles 2)
			)
			(98
				(Palette palSET_INTENSITY 0 255 100)
			)
			(99
				(Message msgGET 740 0 0 3 1 @temp0) ; "The End"
				(Display @temp0 dsALIGN alCENTER dsCOORD 0 80 dsWIDTH 320 dsCOLOR 61 dsFONT 900)
			)
			(100
				(gGlobalSound1 client: 0)
				(modifyPaletteScr start: 0)
				(= local49 1)
				(self setScript: modifyPaletteScr self)
			)
			(101
				(DrawPic 98 100)
				(= cycles 2)
			)
			(102
				(Palette palSET_INTENSITY 0 255 100)
				(self dispose:)
			)
		)
	)
)

(instance fireWorksScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 90)
			)
			(1
				(fireWorks
					show:
					view: (if (< (Random 0 100) 50) 789 else 791)
					loop: 0
					cel: 0
					setCycle: End self
				)
				(switch
					(if (> (++ local42) 5)
						(Random 1 5)
					else
						local42
					)
					(1
						(fireWorks posn: 63 49)
					)
					(2
						(fireWorks posn: 133 33)
					)
					(3
						(fireWorks posn: 194 26)
					)
					(4
						(fireWorks posn: 243 29)
					)
					(5
						(fireWorks posn: 160 62)
					)
				)
			)
			(2
				(fireWorks hide:)
				(if (not register)
					(-= state 2)
					(= ticks 40)
				else
					(fireWorks dispose:)
				)
			)
		)
	)
)

(instance playMusicScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(gMenuBar state: 1)
				(Message msgGET 740 0 0 3 2 @temp0) ; "Now stayed tuned for the greatest hits of Leisure Suit Larry 6!"
				(Display @temp0 dsALIGN alCENTER dsCOORD 0 80 dsWIDTH 320 dsCOLOR 77 dsFONT 900)
				(if (!= (gGlobalSound1 prevSignal:) -1)
					(gGlobalSound1 fade: 0 25 10 1)
					(= ticks 1)
				else
					(++ state)
					(= ticks 360)
				)
			)
			(2
				(if (!= (gGlobalSound1 prevSignal:) -1)
					(-- state)
					(= ticks 30)
				else
					(gMenuBar state: 0)
					(= cycles 2)
				)
			)
			(3
				(DrawPic 98 9)
				(= cycles 2)
			)
			(4
				(gMenuBar state: 1)
				(= local52 1)
				(musicManager register: 1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance musicManager of Script
	(properties)

	(method (cue &tmp [temp0 110])
		(if (== (gGlobalSound1 prevSignal:) -1)
			(if (not register)
				(waitTimer setReal: self 5)
				(= register 1)
				(if (and local52 local53)
					(Display {} dsRESTOREPIXELS local53)
					(= local53 0)
				)
			else
				(Message msgGET 740 0 0 22 (+ local47 2) @temp0)
				(= local53
					(Display
						@temp0
						dsALIGN
						alCENTER
						dsCOORD
						0
						80
						dsWIDTH
						320
						dsCOLOR
						[local0 (Random 0 8)]
						dsFONT
						900
						dsSAVEPIXELS
					)
				)
				(gGlobalSound1
					number:
						(switch (++ local47)
							(0 120)
							(1 230)
							(2 380)
							(3 440)
							(4 442)
							(5 511)
							(6 514)
							(7 560)
							(8 860)
							(9 320)
							(10 420)
							(11 580)
							(12 430)
							(13 840)
							(14 310)
							(15 580)
							(16
								(= local47 -1)
								337
							)
						)
					play: self
				)
				(= register 0)
			)
		)
	)
)

(instance invCursor of Cursor
	(properties
		view 98
	)
)

(instance waitTimer of Timer
	(properties)
)

