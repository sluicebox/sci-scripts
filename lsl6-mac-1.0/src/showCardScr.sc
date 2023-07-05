;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 624)
(include sci.sh)
(use Main)
(use n079)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	showCardScr 0
	finishPlumberScr 1
)

(local
	local0 = -1
	local1
)

(class cObj of Obj
	(properties)
)

(instance exitCue of cObj
	(properties)

	(method (cue)
		(= local1 1)
	)
)

(instance showCardScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 20] [temp20 301])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch global189
					(1
						(= local0 (ScriptID 0 4)) ; icon1
					)
					(4
						(= local0 (ScriptID 0 5)) ; icon2
					)
					(5
						(= local0 (ScriptID 0 6)) ; icon3
					)
					(2
						(= local0 (ScriptID 0 7)) ; icon4
					)
				)
				(switch register
					(1
						(gGame changeScore: 2 237)
					)
					(2
						(gGame changeScore: 2 238)
					)
					(3
						(gGame changeScore: 2 236)
					)
				)
				(if (OneOf register 3 2)
					(gEgo view: 901 setLoop: 1 cel: 0 setCycle: CT 3 1 self)
				else
					(= cycles 2)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(switch register
					(1
						(gMessager say: 4 0 0 1 self) ; "The pink Telephone Services Card reads..."
					)
					(2
						(gMessager say: 5 0 0 1 self) ; "The blue Spa Services Card reads..."
					)
					(3
						(gMessager say: 3 0 0 1 self) ; "The red Housekeeping Services Card reads..."
					)
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(gCast eachElementDo: #hide)
				(switch register
					(3
						(gCurRoom drawPic: 96 7)
					)
					(1
						(gCurRoom drawPic: 97 7)
					)
					(2
						(gCurRoom drawPic: 95 7)
					)
				)
				((ScriptID 0 11) init: self) ; iconExit
				(gTheIconBar enable: (ScriptID 0 11)) ; iconExit
				(= cycles 10)
			)
			(5
				(SetFlag 86)
				((ScriptID 0 11) init: exitCue enable:) ; iconExit
				(gGame setCursor: gNormalCursor)
				(+= state register)
				(= ticks 5)
			)
			(6)
			(7
				(Message msgGET 620 4 0 0 2 @temp20) ; "Welcome to La Costa Lotta!  Touch 8 for Long Distance Touch 9 for Local Calls Touch 0 for Front Desk Touch 71 for Room Service Touch 72 for Bell Desk Touch 73 for Concierge Touch 74 for Excursion Desk Touch 75 for Housekeeping Touch 76 for Building Maintenance"
				(Display @temp20 dsCOORD 90 20 dsFONT gUserFont dsCOLOR 7 dsWIDTH 250)
				(+= state 2)
				(= cycles 2)
			)
			(8
				(Message msgGET 620 5 0 0 2 @temp20) ; "La Costa Lotta is pleased to offer these         exclusive services for our            more sophisticated customers.       Zap away fat in our Electroshock Exercise Center.    Dip into our stimulating Euro-Mud Baths.       Experience the High Colonic Thrill.       Enjoy the dry heat of our Swedish Sauna.        Note: Dr. Swinebutt's World-Famous      Cellulite Drainage Salon is temporarily closed."
				(Display @temp20 dsCOORD 30 21 dsFONT gUserFont dsCOLOR 0 dsWIDTH 305)
				(++ state)
				(= cycles 2)
			)
			(9
				(Message msgGET 620 3 0 0 2 @temp20) ; "La Costa Lotta is pleased to offer     an exclusive complimentary         "Turn Down Service"      for our more sophisticated customers.        Simply Touch 75          on your room telephone."
				(Display @temp20 dsCOORD 56 41 dsFONT gUserFont dsCOLOR 0 dsWIDTH 270)
				(= cycles 2)
			)
			(10
				(if (not local1)
					(-- state)
				else
					(= local1 0)
				)
				(= cycles 2)
			)
			(11
				(ClearFlag 86)
				(gCurRoom drawPic: 620 6)
				(gCast eachElementDo: #show)
				(if (OneOf register 3 2)
					(gEgo setCycle: Beg self)
				else
					(= cycles 2)
				)
			)
			(12
				(if (OneOf register 3 2)
					(gEgo normalize: 900 1)
				else
					(gEgo normalize: 900 2)
				)
				(UnLoad 129 95)
				(UnLoad 129 96)
				(UnLoad 129 97)
				(UnLoad 129 98)
				((ScriptID 0 11) dispose:) ; iconExit
				(= global166 local0)
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 624)
			)
		)
	)
)

(instance finishPlumberScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 231 113 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(markus view: 619 setLoop: 1 x: 280 y: 93 setPri: 1 init:)
				((ScriptID 620 2) number: 1032 loop: 1 play:) ; sfx
				(= ticks 30)
			)
			(4
				((ScriptID 620 4) ; upperDoor
					view: 624
					setLoop: 1
					cel: 0
					setPri: 2
					setCycle: End self
				)
			)
			(5
				((ScriptID 620 4) setPri: 1) ; upperDoor
				(markus setPri: 2 setCycle: Fwd setMotion: MoveTo 254 104 self)
			)
			(6
				(gEgo view: 324 setLoop: 1 cel: 1 setCycle: 0 cycleSpeed: 6)
				(markus setLoop: 2 cel: 1 setCycle: 0)
				(= ticks 30)
			)
			(7
				(markus cel: 0)
				(= ticks 30)
			)
			(8
				((ScriptID 620 4) setCycle: Beg self) ; upperDoor
			)
			(9
				((ScriptID 620 2) number: 1033 loop: 1 play:) ; sfx
				((ScriptID 620 4) view: 620 setLoop: 0 cel: 0 stopUpd:) ; upperDoor
				(= ticks 30)
			)
			(10
				(if (and (IsFlag 34) (not (IsFlag 12)))
					(gMessager say: 0 0 10 0 self) ; "I got your water problem taken care of, Mr. Leper. You won't have any more troubles now."
				else
					(gMessager say: 0 0 11 0 self) ; "Done already?"
				)
			)
			(11
				(markus setLoop: 0 setCycle: Fwd setMotion: MoveTo 258 120 self)
			)
			(12
				(gEgo view: 900 setLoop: 8 cel: 0)
				(markus setLoop: 0 setCycle: Fwd setMotion: MoveTo 261 132 self)
			)
			(13
				(gEgo view: 324 setLoop: 1 cel: 2)
				(markus setLoop: 0 setCycle: Fwd setMotion: MoveTo 278 205 self)
			)
			(14
				(markus dispose:)
				(= cycles 2)
			)
			(15
				(if (and (IsFlag 34) (not (IsFlag 12)))
					(SetFlag 12)
				)
				(if (and (IsFlag 80) (IsFlag 79))
					(ClearFlag 79)
					(ClearFlag 80)
				)
				(ClearFlag 54)
				(ClearFlag 52)
				(ClearFlag 50)
				(gEgo normalize: 900 0)
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 624)
			)
		)
	)
)

(instance markus of Actor
	(properties
		x 265
		y 85
		noun 14
		sightAngle 10
		view 620
	)
)

