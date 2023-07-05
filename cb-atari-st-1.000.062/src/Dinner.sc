;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 209)
(include sci.sh)
(use Main)
(use Interface)
(use Path)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Dinner 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 7] = [73 113 50 149 -20 149 -32768]
)

(procedure (localproc_0)
	(gCast eachElementDo: #hide)
	(DrawPic 67 7)
	(CHead setPri: 1 init:)
	(FHead init: setScript: eyeball)
	(Mouth init:)
	(Eye cycleSpeed: 5 setCycle: Fwd init:)
	(Hand cycleSpeed: 5 init: setScript: handMotion)
)

(procedure (localproc_1)
	(DrawPic 34 6)
	(gAddToPics doit:)
	(gCast eachElementDo: #show)
	(CHead dispose:)
	(FHead dispose:)
	(Mouth dispose:)
	(Eye dispose:)
	(Hand dispose:)
)

(procedure (localproc_2)
	(= local0 (Display &rest dsFONT 41 dsALIGN alCENTER dsCOORD local3 local4 dsWIDTH 260 dsCOLOR 15 dsSAVEPIXELS))
)

(procedure (localproc_3)
	(Display 209 0 dsRESTOREPIXELS local0)
)

(procedure (localproc_4)
	(= local1 (Display &rest dsFONT 41 dsALIGN alCENTER dsCOORD local3 local4 dsWIDTH 260 dsCOLOR 0 dsSAVEPIXELS))
)

(procedure (localproc_5)
	(Display 209 0 dsRESTOREPIXELS local1)
)

(instance wOPath of Path
	(properties)

	(method (at param1)
		(return [local8 param1])
	)
)

(instance Dinner of Rm
	(properties
		picture 34
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gAddToPics
			add:
				tableTop
				chute
				Ethel
				Gertie
				Gloria
				Rudy
				Jeeves
				Clarence
				Wilbur
				chair4
				chair5
				coffee
				chandelier
				flowers
			doit:
		)
		(Load rsPIC 67)
		(LoadMany rsVIEW 0 500 800)
		(Load rsFONT 41)
		(RHead setPri: 14 init: stopUpd:)
		(lHead setPri: 10 init: stopUpd:)
		(yHead setPri: 10 init: stopUpd:)
		(cHead setPri: 10 init: stopUpd:)
		(grHead setPri: 10 init: stopUpd:)
		(eHead setPri: 10 init: stopUpd:)
		(glHead setPri: 10 init: stopUpd:)
		(wHead setPri: 7 init: stopUpd:)
		(You init: stopUpd:)
		(Lilian init: stopUpd:)
		(if gDetailLevel
			(fire setCycle: Fwd init:)
			(gas setPri: 9 setCycle: Fwd init:)
		else
			(gas setPri: 9 init: stopUpd:)
			(fire init: stopUpd:)
		)
		(Colonel illegalBits: 0 setCycle: Walk setPri: 10 init: stopUpd:)
		(self setScript: speech)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 983)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) KEY_S)
						(== (event message:) KEY_s)
						(== (event message:) KEY_RETURN)
						(== (event message:) KEY_SPACE)
					)
					(SetFlag 50)
				)
			)
			(evMOUSEBUTTON
				(SetFlag 50)
			)
		)
		(if (IsFlag 50)
			(event claimed: 1)
			(gCurRoom newRoom: 44)
		)
	)
)

(instance speech of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (myMusic prevSignal:) -1) (== state 20))
			(SetFlag 50)
			(gCurRoom newRoom: 44)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(myMusic number: 4 loop: -1 play:)
				(= local3 41)
				(= local4 32)
				(localproc_4 209 1) ; "System Development by  Robert Heitman Jeff Stephenson Stuart Goldstein Pablo Ghenis Corinna Abdul"
				(= local3 40)
				(= local4 30)
				(localproc_2 209 1) ; "System Development by  Robert Heitman Jeff Stephenson Stuart Goldstein Pablo Ghenis Corinna Abdul"
				(= seconds 8)
			)
			(2
				(localproc_3)
				(localproc_5)
				(= cycles 1)
			)
			(3
				(Print 209 2 #at 104 10 #dispose) ; "During dinner..."
				(Colonel setMotion: MoveTo 75 123 self)
				(cHead setCycle: End)
				(wHead setCycle: End)
				(eHead setCycle: End)
				(grHead setCycle: End)
				(RHead setCycle: End)
				(yHead setCycle: End)
				(lHead setCycle: End)
			)
			(4
				(cls)
				(localproc_0)
				(Print 209 3 #at 10 117 #dispose) ; "I'm glad you are all here. I'm sure you are wondering why I sent for you."
				(= local7 5)
				(Mouth setScript: mouthCyc)
				(Eye loop: 2 setCycle: End)
				(= seconds 10)
			)
			(5
				(cls)
				(Eye setCycle: Beg)
				(= local7 6)
				(Mouth setScript: mouthCyc)
				(Print 209 4 #at 10 117 #dispose) ; "As you know, I'm a very wealthy man. I have invested my money wisely and have put away almost every dime."
				(= seconds 10)
			)
			(6
				(cls)
				(Eye loop: 1 cycleSpeed: 6 setCycle: Fwd)
				(= local7 5)
				(Mouth setScript: mouthCyc)
				(Print 209 5 #at 10 117 #dispose) ; "However, my end is near and I have decided to bequeath my millions to each of you sitting at the table."
				(= seconds 10)
			)
			(7
				(cls)
				(= local7 3)
				(Mouth setScript: mouthCyc)
				(Print 209 6 #at 10 117 #dispose) ; "Except of course Lillian's friend, Laura."
				(= seconds 5)
			)
			(8
				(cls)
				(= local7 1)
				(Mouth setScript: mouthCyc)
				(Print 209 7 #at 10 117 #dispose) ; "AHEM!"
				(= seconds 3)
			)
			(9
				(cls)
				(= local7 5)
				(Mouth setScript: mouthCyc)
				(Print 209 8 #at 10 117 #dispose) ; "Anyway, as I have said, you're all inheriting my money, and you will inherit equally when I go."
				(= seconds 10)
			)
			(10
				(cls)
				(Eye loop: 2 setCycle: End)
				(= local7 5)
				(Mouth setScript: mouthCyc)
				(Print 209 9 #at 10 117 #dispose) ; "If any of you should die before I do, then your share will be distributed equally to the surviving parties."
				(= seconds 10)
			)
			(11
				(cls)
				(Eye setCycle: Beg)
				(= local7 3)
				(Mouth setScript: mouthCyc)
				(Print 209 10 #at 10 117 #dispose) ; "I'm tired, Fifi. Help me back to my room."
				(= seconds 5)
			)
			(12
				(cls)
				(= local7 1)
				(Mouth setScript: mouthCyc)
				(Print 209 11 #at 10 117 #dispose) ; "Good-night, all."
				(Hand setCycle: 0)
				(= seconds 5)
			)
			(13
				(cls)
				(localproc_1)
				(Colonel
					setMotion: MoveTo (Colonel x:) (+ (Colonel y:) 20) self
				)
			)
			(14
				(Colonel setMotion: MoveTo -40 150 self)
			)
			(15
				(cls)
				(cHead setCycle: Beg)
				(wHead setCycle: Beg)
				(eHead setCycle: Beg)
				(grHead setCycle: Beg)
				(RHead setCycle: Beg)
				(yHead setCycle: Beg)
				(lHead setCycle: Beg)
				(= cycles 4)
			)
			(16
				(cls)
				(switch local2
					(0
						(Print 209 12 #at 73 145 #dispose) ; "Can you believe that?!"
						(yHead loop: 4 setCycle: End)
						(lHead loop: 9 setCycle: End)
						(grHead setCycle: End)
					)
					(1
						(Print 209 13 #at 110 28 #dispose) ; "The old goat!"
						(wHead setCycle: Beg)
						(grHead setCycle: Beg)
						(eHead setCycle: End)
						(wHead loop: 1 setCycle: Fwd)
					)
					(2
						(Print 209 14 #at 73 145 #dispose) ; "I'm surprised he didn't try to take it with him!"
						(eHead setCycle: Beg)
						(RHead setCycle: End)
						(cHead loop: 8 setCycle: End)
						(wHead setCycle: 0)
					)
					(3
						(Print 209 15 #at 200 144 #width 75 #dispose) ; "He's such an old skinflint!"
						(RHead setCycle: Beg)
						(cHead setCycle: Beg)
						(grHead loop: 2 setCycle: End)
					)
					(4
						(Print 209 16 #at 149 15 #width 100 #dispose) ; "I don't think you deserve any money!"
						(grHead setCycle: Beg)
						(wHead loop: 4 setCycle: End)
						(eHead loop: 3 setCycle: Fwd)
					)
					(5
						(Print 209 17 #at 110 25 #dispose) ; "Speak for yourself!"
						(wHead setCycle: Beg)
						(eHead loop: 2 setCycle: End)
						(wHead loop: 1 setCycle: Fwd)
					)
					(6
						(Print 209 18 #at 200 144 #width 100 #dispose) ; "How much do you think he's got?"
						(eHead setCycle: Beg)
						(grHead setCycle: End)
						(wHead loop: 1 setCycle: 0)
					)
					(7
						(Print 209 19 #at 204 10 #width 95 #dispose) ; "Well, I know what I'm going to do with MY share!"
						(grHead setCycle: Beg)
						(eHead loop: 1 setCycle: End)
						(glHead setCycle: Fwd)
					)
					(8
						(Print 209 20 #at 149 15 #width 100 #dispose) ; "YOUR SHARE?! I bet the old codger outlives YOU!"
						(eHead setCycle: Beg)
						(wHead loop: 4 setCycle: End)
						(glHead setCycle: 0)
						(eHead loop: 3 setCycle: Fwd)
					)
					(9
						(Print 209 21 #at 144 147 #dispose) ; "I wonder how sick he is?"
						(wHead setCycle: Beg)
						(grHead setCycle: End)
						(eHead setCycle: 0)
					)
					(10
						(Print 209 22 #at 224 15 #width 75 #dispose) ; "Do you think he's gonna go soon?"
						(grHead setCycle: Beg)
						(eHead loop: 1 setCycle: End)
						(glHead setCycle: Fwd)
					)
				)
				(= seconds 3)
			)
			(17
				(cls)
				(glHead setCycle: 0)
				(if (!= local2 10)
					(++ local2)
					(= state 15)
					(= cycles 1)
				else
					(yHead setCycle: Beg self)
				)
			)
			(18
				(chair addToPic:)
				(yHead loop: 3 setCycle: End)
				(cHead loop: 7 setCycle: End)
				(wHead loop: 5 setCycle: End)
				(eHead loop: 2 setCycle: End)
				(grHead loop: 1 setCycle: End)
				(RHead setCycle: End)
				(lHead dispose:)
				(Lilian
					startUpd:
					view: 800
					loop: 4
					cel: 0
					x: 100
					y: 118
					illegalBits: 0
					ignoreActors: 1
					setCycle: Fwd
				)
				(Print 209 23 #at 40 18 #dispose) ; "I've had enough of this! Laura and I will retire to our room now."
				(= seconds 5)
			)
			(19
				(cls)
				(Lilian
					view: 500
					loop: 2
					setCycle: Walk
					setMotion: (Clone wOPath)
				)
				(chair1 addToPic:)
				(yHead hide:)
				(You
					view: 0
					loop: 2
					x: 124
					y: 118
					startUpd:
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setMotion: (Clone wOPath) self
				)
			)
			(20
				(myMusic fade:)
			)
			(21
				(client setScript: 0)
				(gCurRoom newRoom: 44)
			)
		)
	)
)

(instance eyeball of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(FHead setCycle: End)
				(= seconds (Random 1 6))
			)
			(1
				(= state -1)
				(= seconds (Random 1 6))
			)
		)
	)
)

(instance handMotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Hand setCycle: End)
				(= seconds (Random 1 6))
			)
			(1
				(= state -1)
				(= seconds (Random 1 6))
			)
		)
	)
)

(instance mouthCyc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(++ local6)
				(if (== local7 local6)
					(= local6 0)
					(client cel: 0 setScript: 0)
				else
					(= state -1)
					(= cycles 1)
				)
			)
		)
	)
)

(instance tableTop of PV
	(properties
		y 107
		x 151
		view 167
		loop 6
		priority 9
	)
)

(instance chute of PV
	(properties
		y 121
		x 23
		view 134
		loop 2
	)
)

(instance Wilbur of PV
	(properties
		y 118
		x 152
		view 421
		priority 7
	)
)

(instance Jeeves of PV
	(properties
		y 105
		x 175
		view 450
		priority 7
	)
)

(instance Clarence of PV
	(properties
		y 135
		x 132
		view 401
		cel 5
		priority 10
	)
)

(instance Ethel of PV
	(properties
		y 118
		x 178
		view 321
		cel 2
		priority 7
	)
)

(instance Gertie of PV
	(properties
		y 135
		x 161
		view 341
		cel 1
		priority 10
	)
)

(instance Gloria of PV
	(properties
		y 119
		x 218
		view 361
		cel 1
		priority 8
	)
)

(instance Rudy of PV
	(properties
		y 135
		x 199
		view 381
		cel 1
		priority 10
	)
)

(instance chair4 of PV
	(properties
		y 90
		x 205
		view 134
		loop 6
		cel 1
		priority 5
	)
)

(instance chair5 of PV
	(properties
		y 90
		x 50
		view 134
		loop 6
		priority 5
	)
)

(instance coffee of PV
	(properties
		y 138
		x 301
		view 134
		priority 12
	)
)

(instance chandelier of PV
	(properties
		y 42
		x 144
		view 134
		cel 3
		priority 9
	)
)

(instance flowers of PV
	(properties
		y 55
		x 129
		view 134
		cel 2
		priority 9
	)
)

(instance yHead of Prop
	(properties
		y 82
		x 123
		view 2
		loop 3
	)
)

(instance lHead of Prop
	(properties
		y 82
		x 99
		view 501
		loop 8
	)
)

(instance cHead of Prop
	(properties
		y 101
		x 135
		view 401
		loop 7
	)
)

(instance grHead of Prop
	(properties
		y 101
		x 163
		view 341
		loop 1
	)
)

(instance RHead of Prop
	(properties
		y 99
		x 201
		view 381
		loop 7
	)
)

(instance glHead of Prop
	(properties
		y 84
		x 221
		view 361
		loop 1
	)
)

(instance eHead of Prop
	(properties
		y 83
		x 180
		view 321
		loop 2
		priority 10
	)
)

(instance wHead of Prop
	(properties
		y 83
		x 152
		view 421
		loop 8
		priority 10
	)
)

(instance fire of Prop
	(properties
		y 85
		x 131
		view 232
		cel 1
		priority 5
	)
)

(instance Colonel of Act
	(properties
		y 150
		x -10
		view 306
	)
)

(instance You of Act
	(properties
		y 118
		x 124
		view 2
	)
)

(instance Lilian of Act
	(properties
		y 118
		x 100
		view 501
		cel 1
	)
)

(instance chair of Prop
	(properties
		y 114
		x 94
		view 134
		loop 5
		cel 4
		priority 6
	)
)

(instance chair1 of Prop
	(properties
		y 116
		x 118
		view 134
		loop 5
		cel 3
		priority 6
	)
)

(instance myMusic of Sound
	(properties)
)

(instance gas of Prop
	(properties
		y 82
		x 24
		view 134
		loop 3
		cel 1
		priority 9
	)
)

(instance CHead of Prop
	(properties
		y 96
		x 173
		view 167
		priority 1
	)
)

(instance FHead of Prop
	(properties
		y 39
		x 109
		view 167
		loop 5
		cel 1
		priority 1
	)
)

(instance Eye of Prop
	(properties
		y 85
		x 180
		view 167
		loop 1
	)
)

(instance Mouth of Prop
	(properties
		y 106
		x 177
		view 167
		loop 3
	)
)

(instance Hand of Prop
	(properties
		y 147
		x 186
		view 167
		loop 4
		priority 1
	)
)

