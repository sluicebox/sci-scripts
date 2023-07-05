;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40300)
(include sci.sh)
(use Main)
(use ScrollExit)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use DialogPlane)
(use CueMe)
(use NewUser)
(use n64896)
(use Scaler)
(use PolyPath)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roSpitsOfLand 0
)

(local
	thebitmap
)

(instance oSpitsScrollPlane of TorScrollPlane
	(properties
		priority 20
	)

	(method (addPics)
		(AddPicAt self 40300 0 0)
		(AddPicAt self 40301 632 0)
		(AddPicAt self 40302 1264 0)
	)
)

(instance voWrench of Prop
	(properties
		x 1446
		y 128
		view 40300
	)

	(method (init)
		(super init: &rest)
		(foWrench init:)
		(self setScript: soWrench)
	)

	(method (dispose)
		(foWrench dispose:)
		(super dispose: &rest)
	)
)

(instance soWrench of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(voWrench setCel: 0 setCycle: End self)
			)
			(1
				(= ticks (voWrench cycleSpeed:))
			)
			(2
				(= state -1)
				(= ticks (Random 300 1500))
			)
		)
	)
)

(instance foWrench of Feature
	(properties
		nsLeft 1436
		nsTop 120
		nsRight 1456
		nsBottom 135
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soTakeWrench)
	)
)

(instance soTakeWrench of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 1456 135 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(2
				(self setScript: (ScriptID 64007 1) self self) ; soEgoGetLow
			)
			(3
				(gEgo get: ((ScriptID 64001 0) get: 37)) ; oInvHandler, ioWrench
				((ScriptID 64017 0) set: 152) ; oFlags
				(voWrench dispose:)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foWaterCannon of Feature
	(properties
		nsLeft 1757
		nsTop 52
		nsRight 1851
		nsBottom 68
	)

	(method (init)
		(super init: &rest)
		(gTheDoits add: oTestNearCannon)
	)
)

(instance foDestination of Feature
	(properties
		nsLeft 1694
		nsTop 41
		nsRight 1801
		nsBottom 73
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(if (<= (gEgo y:) 80)
			(gEgo setMotion: PolyPath 1773 62)
		else
			(gMessager say: 3 1 0 0 0 40600) ; "That must be the way out of here."
		)
	)
)

(instance oTestNearCannon of Code
	(properties)

	(method (doit)
		(if (foWaterCannon onMe: gEgo)
			(gCurRoom newRoom: 40500) ; roLavaCrossing
		)
	)
)

(instance oLavaDetector of Code
	(properties)

	(method (doit)
		(if (Bitmap 12 thebitmap (gEgo x:) (gEgo y:)) ; GetColor
			(return 1)
		else
			(return 0)
		)
	)
)

(instance oRightClickHandler of EventCode
	(properties)

	(method (handleEvent event &tmp ppDest oHintSound strText strTitle strContinue)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(& (event modifiers:) emSHIFT)
				(gUser canControl:)
				(gEgo bIsInitialized:)
				(gEgo isNotHidden:)
				(gEgo plane:)
				((gEgo plane:) isEnabled:)
				((gEgo plane:) onMe: (event globalize: yourself:))
			)
			(= oHintSound (TPSound new:))
			(oHintSound playMessage: 0 0 13 3 0 104)
			(= strText (MakeMessageText 0 0 13 3 104))
			(= strTitle (MakeMessageText 0 0 31 1 0))
			(= strContinue (MakeMessageText 0 0 1 1 0))
			(TextDialog strText strContinue strTitle)
			(oHintSound stop: dispose:)
			(event claimed: 1)
		)
		(event claimed:)
	)
)

(instance oMusic2 of TPSound
	(properties
		type 1
	)
)

(instance coMusic of CueMe
	(properties)

	(method (cue)
		(goMusic1 setMusic: 40300)
	)
)

(instance poLava1 of Prop
	(properties
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava1)
	)
)

(instance soLava1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava1 hide: setCel: 0)
				(= ticks (Random 1 240))
			)
			(1
				(switch (Random 0 10)
					(0
						(poLava1 posn: 1621 298)
					)
					(1
						(poLava1 posn: 1685 284)
					)
					(2
						(poLava1 posn: 1700 305)
					)
					(3
						(poLava1 posn: 1720 324)
					)
					(4
						(poLava1 posn: 1754 281)
					)
					(5
						(poLava1 posn: 1776 308)
					)
					(6
						(poLava1 posn: 1823 321)
					)
					(7
						(poLava1 posn: 1824 301)
					)
					(8
						(poLava1 posn: 1841 286)
					)
					(9
						(poLava1 posn: 1876 297)
					)
					(10
						(poLava1 posn: 926 241)
					)
				)
				(poLava1 show: setCycle: End self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava2 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava2)
	)
)

(instance soLava2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava2 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava2 loop: 2)
					)
					(1
						(poLava2 loop: 3)
					)
					(2
						(poLava2 loop: 4)
					)
					(3
						(poLava2 loop: 7)
					)
					(4
						(poLava2 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava2 posn: 28 47)
					)
					(1
						(poLava2 posn: 92 33)
					)
					(2
						(poLava2 posn: 142 31)
					)
					(3
						(poLava2 posn: 200 27)
					)
					(4
						(poLava2 posn: 213 47)
					)
					(5
						(poLava2 posn: 255 49)
					)
					(6
						(poLava2 posn: 97 55)
					)
					(7
						(poLava2 posn: 49 82)
					)
					(8
						(poLava2 posn: 91 84)
					)
					(9
						(poLava2 posn: 127 85)
					)
					(10
						(poLava2 posn: 164 87)
					)
					(11
						(poLava2 posn: 213 88)
					)
					(12
						(poLava2 posn: 272 89)
					)
					(13
						(poLava2 posn: 330 89)
					)
				)
				(poLava2 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava3 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava2)
	)
)

(instance soLava3 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava3 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava3 loop: 2)
					)
					(1
						(poLava3 loop: 3)
					)
					(2
						(poLava3 loop: 4)
					)
					(3
						(poLava3 loop: 7)
					)
					(4
						(poLava3 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava3 posn: 42 111)
					)
					(1
						(poLava3 posn: 82 114)
					)
					(2
						(poLava3 posn: 113 118)
					)
					(3
						(poLava3 posn: 171 122)
					)
					(4
						(poLava3 posn: 213 119)
					)
					(5
						(poLava3 posn: 256 121)
					)
					(6
						(poLava3 posn: 309 120)
					)
					(7
						(poLava3 posn: 112 138)
					)
					(8
						(poLava3 posn: 61 137)
					)
					(9
						(poLava3 posn: 36 155)
					)
					(10
						(poLava3 posn: 34 172)
					)
					(11
						(poLava3 posn: 111 193)
					)
					(12
						(poLava3 posn: 220 187)
					)
					(13
						(poLava3 posn: 270 184)
					)
				)
				(poLava3 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava4 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava4)
	)
)

(instance soLava4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava4 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava4 loop: 2)
					)
					(1
						(poLava4 loop: 3)
					)
					(2
						(poLava4 loop: 4)
					)
					(3
						(poLava4 loop: 7)
					)
					(4
						(poLava4 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava4 posn: 266 203)
					)
					(1
						(poLava4 posn: 76 240)
					)
					(2
						(poLava4 posn: 13 279)
					)
					(3
						(poLava4 posn: 87 255)
					)
					(4
						(poLava4 posn: 128 307)
					)
					(5
						(poLava4 posn: 170 291)
					)
					(6
						(poLava4 posn: 234 285)
					)
					(7
						(poLava4 posn: 233 256)
					)
					(8
						(poLava4 posn: 281 245)
					)
					(9
						(poLava4 posn: 331 292)
					)
					(10
						(poLava4 posn: 353 309)
					)
					(11
						(poLava4 posn: 341 240)
					)
					(12
						(poLava4 posn: 375 239)
					)
					(13
						(poLava4 posn: 314 204)
					)
				)
				(poLava4 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava5 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava5)
	)
)

(instance soLava5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava5 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava5 loop: 2)
					)
					(1
						(poLava5 loop: 3)
					)
					(2
						(poLava5 loop: 4)
					)
					(3
						(poLava5 loop: 7)
					)
					(4
						(poLava5 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava5 posn: 614 25)
					)
					(1
						(poLava5 posn: 566 30)
					)
					(2
						(poLava5 posn: 510 27)
					)
					(3
						(poLava5 posn: 454 28)
					)
					(4
						(poLava5 posn: 375 29)
					)
					(5
						(poLava5 posn: 401 65)
					)
					(6
						(poLava5 posn: 456 65)
					)
					(7
						(poLava5 posn: 511 67)
					)
					(8
						(poLava5 posn: 613 69)
					)
					(9
						(poLava5 posn: 604 101)
					)
					(10
						(poLava5 posn: 465 89)
					)
					(11
						(poLava5 posn: 454 114)
					)
					(12
						(poLava5 posn: 361 87)
					)
					(13
						(poLava5 posn: 344 119)
					)
				)
				(poLava5 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava6 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava6)
	)
)

(instance soLava6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava6 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava6 loop: 2)
					)
					(1
						(poLava6 loop: 3)
					)
					(2
						(poLava6 loop: 4)
					)
					(3
						(poLava6 loop: 7)
					)
					(4
						(poLava6 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava6 posn: 360 142)
					)
					(1
						(poLava6 posn: 411 145)
					)
					(2
						(poLava6 posn: 482 149)
					)
					(3
						(poLava6 posn: 594 147)
					)
					(4
						(poLava6 posn: 608 178)
					)
					(5
						(poLava6 posn: 543 179)
					)
					(6
						(poLava6 posn: 490 179)
					)
					(7
						(poLava6 posn: 438 178)
					)
					(8
						(poLava6 posn: 375 180)
					)
					(9
						(poLava6 posn: 367 203)
					)
					(10
						(poLava6 posn: 430 203)
					)
					(11
						(poLava6 posn: 547 204)
					)
					(12
						(poLava6 posn: 604 226)
					)
					(13
						(poLava6 posn: 319 314)
					)
				)
				(poLava6 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava7 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava7)
	)
)

(instance soLava7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava7 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava7 loop: 2)
					)
					(1
						(poLava7 loop: 3)
					)
					(2
						(poLava7 loop: 4)
					)
					(3
						(poLava7 loop: 7)
					)
					(4
						(poLava7 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava7 posn: 345 290)
					)
					(1
						(poLava7 posn: 307 233)
					)
					(2
						(poLava7 posn: 329 246)
					)
					(3
						(poLava7 posn: 354 236)
					)
					(4
						(poLava7 posn: 397 241)
					)
					(5
						(poLava7 posn: 457 236)
					)
					(6
						(poLava7 posn: 509 236)
					)
					(7
						(poLava7 posn: 616 235)
					)
					(8
						(poLava7 posn: 450 227)
					)
					(9
						(poLava7 posn: 508 269)
					)
					(10
						(poLava7 posn: 557 271)
					)
					(11
						(poLava7 posn: 614 266)
					)
					(12
						(poLava7 posn: 798 11)
					)
					(13
						(poLava7 posn: 620 109)
					)
				)
				(poLava7 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava8 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava8)
	)
)

(instance soLava8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava8 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava8 loop: 2)
					)
					(1
						(poLava8 loop: 3)
					)
					(2
						(poLava8 loop: 4)
					)
					(3
						(poLava8 loop: 7)
					)
					(4
						(poLava8 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava8 posn: 1877 47)
					)
					(1
						(poLava8 posn: 1836 48)
					)
					(2
						(poLava8 posn: 1685 48)
					)
					(3
						(poLava8 posn: 1600 40)
					)
					(4
						(poLava8 posn: 1566 80)
					)
					(5
						(poLava8 posn: 1624 71)
					)
					(6
						(poLava8 posn: 1675 79)
					)
					(7
						(poLava8 posn: 1750 81)
					)
					(8
						(poLava8 posn: 1816 84)
					)
					(9
						(poLava8 posn: 1775 95)
					)
					(10
						(poLava8 posn: 1728 96)
					)
					(11
						(poLava8 posn: 1684 101)
					)
					(12
						(poLava8 posn: 1621 96)
					)
					(13
						(poLava8 posn: 1576 104)
					)
				)
				(poLava8 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava9 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava9)
	)
)

(instance soLava9 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava9 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava9 loop: 2)
					)
					(1
						(poLava9 loop: 3)
					)
					(2
						(poLava9 loop: 4)
					)
					(3
						(poLava9 loop: 7)
					)
					(4
						(poLava9 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava9 posn: 1842 130)
					)
					(1
						(poLava9 posn: 1799 128)
					)
					(2
						(poLava9 posn: 1751 128)
					)
					(3
						(poLava9 posn: 1675 126)
					)
					(4
						(poLava9 posn: 1623 156)
					)
					(5
						(poLava9 posn: 1680 172)
					)
					(6
						(poLava9 posn: 1721 162)
					)
					(7
						(poLava9 posn: 1796 170)
					)
					(8
						(poLava9 posn: 1821 221)
					)
					(9
						(poLava9 posn: 1873 224)
					)
					(10
						(poLava9 posn: 1703 211)
					)
					(11
						(poLava9 posn: 1712 233)
					)
					(12
						(poLava9 posn: 1793 242)
					)
					(13
						(poLava9 posn: 1655 243)
					)
				)
				(poLava9 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava10 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava10)
	)
)

(instance soLava10 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava10 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava10 loop: 2)
					)
					(1
						(poLava10 loop: 3)
					)
					(2
						(poLava10 loop: 4)
					)
					(3
						(poLava10 loop: 7)
					)
					(4
						(poLava10 loop: 8)
					)
				)
				(switch (Random 0 9)
					(0
						(poLava10 posn: 1294 37)
					)
					(1
						(poLava10 posn: 1368 37)
					)
					(2
						(poLava10 posn: 1427 79)
					)
					(3
						(poLava10 posn: 1314 79)
					)
					(4
						(poLava10 posn: 1292 106)
					)
					(5
						(poLava10 posn: 1492 104)
					)
					(6
						(poLava10 posn: 1374 134)
					)
					(7
						(poLava10 posn: 1294 148)
					)
					(8
						(poLava10 posn: 1430 151)
					)
					(9
						(poLava10 posn: 1499 156)
					)
				)
				(poLava10 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava11 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava11)
	)
)

(instance soLava11 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava11 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava11 loop: 2)
					)
					(1
						(poLava11 loop: 3)
					)
					(2
						(poLava11 loop: 4)
					)
					(3
						(poLava11 loop: 7)
					)
					(4
						(poLava11 loop: 8)
					)
				)
				(switch (Random 0 7)
					(0
						(poLava11 posn: 1558 156)
					)
					(1
						(poLava11 posn: 1585 193)
					)
					(2
						(poLava11 posn: 1416 178)
					)
					(3
						(poLava11 posn: 1361 174)
					)
					(4
						(poLava11 posn: 1295 209)
					)
					(5
						(poLava11 posn: 1386 204)
					)
					(6
						(poLava11 posn: 1556 224)
					)
					(7
						(poLava11 posn: 1616 244)
					)
				)
				(poLava11 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava12 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava12)
	)
)

(instance soLava12 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava12 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava12 loop: 2)
					)
					(1
						(poLava12 loop: 3)
					)
					(2
						(poLava12 loop: 4)
					)
					(3
						(poLava12 loop: 7)
					)
					(4
						(poLava12 loop: 8)
					)
				)
				(switch (Random 0 9)
					(0
						(poLava12 posn: 1548 251)
					)
					(1
						(poLava12 posn: 1493 260)
					)
					(2
						(poLava12 posn: 1429 261)
					)
					(3
						(poLava12 posn: 1379 263)
					)
					(4
						(poLava12 posn: 1314 265)
					)
					(5
						(poLava12 posn: 1272 276)
					)
					(6
						(poLava12 posn: 1377 294)
					)
					(7
						(poLava12 posn: 1438 313)
					)
				)
				(poLava12 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava13 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava13)
	)
)

(instance soLava13 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava13 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava13 loop: 2)
					)
					(1
						(poLava13 loop: 3)
					)
					(2
						(poLava13 loop: 4)
					)
					(3
						(poLava13 loop: 7)
					)
					(4
						(poLava13 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava13 posn: 677 20)
					)
					(1
						(poLava13 posn: 714 18)
					)
					(2
						(poLava13 posn: 750 18)
					)
					(3
						(poLava13 posn: 806 21)
					)
					(4
						(poLava13 posn: 853 20)
					)
					(5
						(poLava13 posn: 923 27)
					)
					(6
						(poLava13 posn: 684 28)
					)
					(7
						(poLava13 posn: 839 40)
					)
					(8
						(poLava13 posn: 651 63)
					)
					(9
						(poLava13 posn: 698 60)
					)
					(10
						(poLava13 posn: 766 65)
					)
					(11
						(poLava13 posn: 764 58)
					)
					(12
						(poLava13 posn: 941 80)
					)
					(13
						(poLava13 posn: 700 71)
					)
				)
				(poLava13 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava14 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava14)
	)
)

(instance soLava14 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava14 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava14 loop: 2)
					)
					(1
						(poLava14 loop: 3)
					)
					(2
						(poLava14 loop: 4)
					)
					(3
						(poLava14 loop: 7)
					)
					(4
						(poLava14 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava14 posn: 652 95)
					)
					(1
						(poLava14 posn: 696 97)
					)
					(2
						(poLava14 posn: 780 93)
					)
					(3
						(poLava14 posn: 931 110)
					)
					(4
						(poLava14 posn: 871 114)
					)
					(5
						(poLava14 posn: 802 113)
					)
					(6
						(poLava14 posn: 707 115)
					)
					(7
						(poLava14 posn: 645 119)
					)
					(8
						(poLava14 posn: 655 142)
					)
					(9
						(poLava14 posn: 717 140)
					)
					(10
						(poLava14 posn: 784 145)
					)
					(11
						(poLava14 posn: 854 139)
					)
					(12
						(poLava14 posn: 939 131)
					)
					(13
						(poLava14 posn: 775 170)
					)
				)
				(poLava14 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava15 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava15)
	)
)

(instance soLava15 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava15 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava15 loop: 2)
					)
					(1
						(poLava15 loop: 3)
					)
					(2
						(poLava15 loop: 4)
					)
					(3
						(poLava15 loop: 7)
					)
					(4
						(poLava15 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava15 posn: 750 177)
					)
					(1
						(poLava15 posn: 707 178)
					)
					(2
						(poLava15 posn: 659 177)
					)
					(3
						(poLava15 posn: 640 216)
					)
					(4
						(poLava15 posn: 683 225)
					)
					(5
						(poLava15 posn: 722 217)
					)
					(6
						(poLava15 posn: 764 217)
					)
					(7
						(poLava15 posn: 814 207)
					)
					(8
						(poLava15 posn: 857 205)
					)
					(9
						(poLava15 posn: 899 193)
					)
					(10
						(poLava15 posn: 929 168)
					)
					(11
						(poLava15 posn: 902 234)
					)
					(12
						(poLava15 posn: 669 264)
					)
					(13
						(poLava15 posn: 886 264)
					)
				)
				(poLava15 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava16 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava16)
	)
)

(instance soLava16 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava16 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava16 loop: 2)
					)
					(1
						(poLava16 loop: 3)
					)
					(2
						(poLava16 loop: 4)
					)
					(3
						(poLava16 loop: 7)
					)
					(4
						(poLava16 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava16 posn: 1241 36)
					)
					(1
						(poLava16 posn: 1189 35)
					)
					(2
						(poLava16 posn: 1090 36)
					)
					(3
						(poLava16 posn: 1021 28)
					)
					(4
						(poLava16 posn: 1017 66)
					)
					(5
						(poLava16 posn: 1054 59)
					)
					(6
						(poLava16 posn: 1101 62)
					)
					(7
						(poLava16 posn: 1154 60)
					)
					(8
						(poLava16 posn: 1154 75)
					)
					(9
						(poLava16 posn: 1199 77)
					)
					(10
						(poLava16 posn: 1244 79)
					)
					(11
						(poLava16 posn: 1247 106)
					)
					(12
						(poLava16 posn: 1206 118)
					)
					(13
						(poLava16 posn: 1097 93)
					)
				)
				(poLava16 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava17 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava17)
	)
)

(instance soLava17 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava17 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava17 loop: 2)
					)
					(1
						(poLava17 loop: 3)
					)
					(2
						(poLava17 loop: 4)
					)
					(3
						(poLava17 loop: 7)
					)
					(4
						(poLava17 loop: 8)
					)
				)
				(switch (Random 0 11)
					(0
						(poLava17 posn: 984 134)
					)
					(1
						(poLava17 posn: 1027 135)
					)
					(2
						(poLava17 posn: 1089 139)
					)
					(3
						(poLava17 posn: 1146 141)
					)
					(4
						(poLava17 posn: 1253 149)
					)
					(5
						(poLava17 posn: 1239 174)
					)
					(6
						(poLava17 posn: 1108 173)
					)
					(7
						(poLava17 posn: 1066 170)
					)
					(8
						(poLava17 posn: 1014 169)
					)
					(9
						(poLava17 posn: 1026 107)
					)
					(10
						(poLava17 posn: 1007 83)
					)
					(11
						(poLava17 posn: 991 112)
					)
				)
				(poLava17 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava18 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava18)
	)
)

(instance soLava18 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava18 hide: setCel: 0)
				(= ticks 1)
			)
			(1
				(= ticks (Random 1 120))
			)
			(2
				(switch (Random 0 4)
					(0
						(poLava18 loop: 2)
					)
					(1
						(poLava18 loop: 3)
					)
					(2
						(poLava18 loop: 4)
					)
					(3
						(poLava18 loop: 7)
					)
					(4
						(poLava18 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava18 posn: 1246 271)
					)
					(1
						(poLava18 posn: 1183 263)
					)
					(2
						(poLava18 posn: 1122 270)
					)
					(3
						(poLava18 posn: 1086 252)
					)
					(4
						(poLava18 posn: 1102 235)
					)
					(5
						(poLava18 posn: 1165 238)
					)
					(6
						(poLava18 posn: 1191 224)
					)
					(7
						(poLava18 posn: 1253 214)
					)
					(8
						(poLava18 posn: 1209 202)
					)
					(9
						(poLava18 posn: 1167 210)
					)
					(10
						(poLava18 posn: 1129 207)
					)
					(11
						(poLava18 posn: 1047 199)
					)
					(12
						(poLava18 posn: 962 232)
					)
					(13
						(poLava18 posn: 955 269)
					)
				)
				(poLava18 show: setCycle: End self)
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance roSpitsOfLand of TPRoom
	(properties)

	(method (init)
		(super init: &rest)
		(gOEventHandler
			unregisterGlobalHandler: (ScriptID 64010 1) ; oRightClickHandler
			registerGlobalHandler: oRightClickHandler
		)
		(= plane
			(oSpitsScrollPlane
				oEScrollExit: 0
				oWScrollExit: 0
				init: 1896 (gThePlane getHeight:)
				yourself:
			)
		)
		(goMusic1 stop:)
		(oMusic2 playSound: 40499 coMusic)
		(if (not ((ScriptID 64017 0) test: 152)) ; oFlags
			(voWrench init:)
		)
		(gEgo
			init:
			normalize:
			loop: 3
			setScaler: Scaler 35 20 297 45
			oCantBeHereHandler: oLavaDetector
		)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(40500 ; roLavaCrossing
				(gEgo posn: 1843 72)
				(plane scrollTo: 1264 0)
			)
			(else
				(foDestination init:)
				(gEgo posn: 1023 299)
				(plane scrollTo: 632 0)
			)
		)
		(foWaterCannon init:)
		(= thebitmap (Bitmap 9 40300 1 0 0 0)) ; CreateWithCel
		(poLava1 init:)
		(poLava2 init:)
		(poLava3 init:)
		(poLava4 init:)
		(poLava5 init:)
		(poLava6 init:)
		(poLava7 init:)
		(poLava8 init:)
		(poLava9 init:)
		(poLava10 init:)
		(poLava11 init:)
		(poLava12 init:)
		(poLava13 init:)
		(poLava14 init:)
		(poLava15 init:)
		(poLava16 init:)
		(poLava17 init:)
		(poLava18 init:)
	)

	(method (dispose)
		(gOEventHandler
			unregisterGlobalHandler: oRightClickHandler
			registerGlobalHandler: (ScriptID 64010 1) ; oRightClickHandler
		)
		(Bitmap 1 thebitmap) ; Dispose
		(super dispose: &rest)
	)

	(method (gimme))
)

