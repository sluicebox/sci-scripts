;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm53 0
)

(procedure (localproc_0)
	(proc0_7)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(instance rm53 of Rm
	(properties
		picture 54
		horizon 102
	)

	(method (init)
		(self style: 4)
		(Load rsSOUND 101)
		(LoadMany rsPIC 53 54 99)
		(LoadMany rsVIEW 46 82 253 255 5 0 553 191 190 194 192 49)
		(super init:)
		(gEgo posn: 262 187 loop: 3 init:)
		(proc0_1)
		(self setScript: endCartoon)
	)
)

(instance endCartoon of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(or
				(== (event type:) evMOUSEBUTTON)
				(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
			)
			(if gModelessDialog
				(proc0_7)
				(gModelessDialog dispose:)
				(if seconds
					(= seconds 0)
					(= cycles 1)
				)
				(if register
					(= register 0)
					(= cycles 1)
				)
			)
			(event claimed: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 53 0 #at -1 20 #width 280 #mode 1 #dispose) ; "More curious still, the courtyard is deserted; this area is usually filled with the Ladies and Lords of the castle."
				(gEgo view: 82 loop: 0 cel: 0)
				(head
					posn: (+ (gEgo x:) 1) (- (gEgo y:) 38)
					setLoop: 1
					cel: 3
					cycleSpeed: 2
					init:
					setCycle: End
				)
				(= seconds 6)
			)
			(1
				(localproc_0)
				(head hide:)
				(gEgo
					view: 46
					cycleSpeed: 0
					setStep: 3 3
					setCycle: Walk
					setLoop: 0
					setMotion: MoveTo 158 102 self
				)
			)
			(2
				(Print 53 1 #at -1 130 #width 280 #mode 1 #dispose) ; "This is highly unusual. You begin to feel deeply disturbed, as if all is not right within the castle."
				(gEgo view: 82 loop: 0 cel: 1)
				(head
					posn: (+ (gEgo x:) 1) (- (gEgo y:) 38)
					setLoop: 2
					cel: 4
					show:
					setCycle: End
				)
				(= seconds 6)
			)
			(3
				(localproc_0)
				(head dispose:)
				(gEgo
					view: 46
					setLoop: 0
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Walk
					setMotion: MoveTo 83 57 self
				)
			)
			(4
				(Print 53 2 #at -1 130 #width 280 #mode 1 #dispose) ; "You can faintly hear a commotion in the King's Chamber to the west."
				(= seconds 6)
			)
			(5
				(localproc_0)
				(gEgo
					view: 46
					cycleSpeed: 0
					moveSpeed: 0
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo -10 34 self
				)
			)
			(6
				(gCurRoom picture: 53 style: 2 drawPic: 53)
				(gEgo posn: 330 144 loop: 1)
				(king init:)
				(doctor init:)
				(rs1and2Body init:)
				(rs2Arm init: setCycle: Fwd)
				(rs2Head init:)
				(rs1Head init:)
				(crowd1 init:)
				(gAddToPics add: crowd2 crowd2Part1 eachElementDo: #init doit:)
				(crowd3 init:)
				(crowd1Head1 init:)
				(crowd1Head2 init:)
				(crowd1Head3 init:)
				(crowd1Head4 init:)
				(crowd2Head1 init:)
				(crowd2Head2 init:)
				(crowd2Head3 init:)
				(crowd3Head1 init:)
				(self cue:)
				(proc0_1)
			)
			(7
				(head
					view: 192
					posn: (+ (doctor x:) 1) (- (doctor y:) 38)
					loop: 9
					setPri: 9
					cycleSpeed: 1
					setCycle: Fwd
					init:
				)
				(Print 53 3 #at -1 20 #width 280 #mode 1 #dispose) ; "DOCTOR: "There's nothing to be done.""
				(= seconds 6)
			)
			(8
				(localproc_0)
				(Print 53 4 #at -1 115 #width 280 #mode 1 #dispose) ; "DOCTOR: "Our King's melancholy is too much for his heart to bear. Perhaps if Sir Graham had returned with the three lost treasures of Daventry ...""
				(= seconds 9)
			)
			(9
				(localproc_0)
				(head hide:)
				(gEgo setCycle: StopWalk 2 setMotion: MoveTo 312 144)
				(= seconds 3)
			)
			(10
				(self setScript: crowdTalk self)
				(doctor setCycle: End)
				(gEgo
					illegalBits: 0
					setMotion: DPath 207 144 173 123 139 123 self
				)
			)
			(11
				(= cycles 0)
			)
			(12
				(crowd2Head1 stopUpd:)
				(crowd2Head2 stopUpd:)
				(crowd2Head3 stopUpd:)
				(gEgo view: 5 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(13
				(DisposeScript 964)
				(Print 53 5 #at -1 20 #width 280 #mode 1 #dispose) ; "SIR GRAHAM: "Your Highness, I am at your service.""
				(gramHead
					init:
					setCycle: Fwd
					cycleSpeed: 1
					setPri: (+ (gEgo priority:) 1)
				)
				(= seconds 5)
			)
			(14
				(gramHead hide:)
				(king setCycle: Beg self)
			)
			(15
				(localproc_0)
				(talkingHead
					init:
					startUpd:
					setCycle: Fwd
					cycleSpeed: 1
					setPri: 10
				)
				(Print 53 6 #at -1 20 #width 280 #mode 1 #dispose) ; "KING: "Did ... did you succeed in your quest?""
				(= seconds 5)
			)
			(16
				(talkingHead dispose:)
				(gramHead show:)
				(Print 53 7 #at -1 20 #width 280 #mode 1 #dispose) ; "SIR GRAHAM: "I did, Your Majesty.""
				(= seconds 4)
			)
			(17
				(localproc_0)
				(gramHead dispose:)
				(Print 53 8 #at -1 20 #width 280 #mode 1 #dispose) ; "SIR GRAHAM: "Here, as you commanded ...""
				(gEgo setCycle: Beg self)
			)
			(18
				(localproc_0)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: StopWalk 2
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(+ (gEgo y:) 15)
						self
				)
			)
			(19
				(gEgo setMotion: MoveTo 80 146 self)
			)
			(20
				(gEgo
					view: 49
					ignoreActors:
					loop: 0
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(21
				(Print 53 9 #at -1 20 #width 280 #mode 1 #dispose) ; "SIR GRAHAM: "...the magic mirror.""
				(= seconds 3)
			)
			(22
				(gAddToPics add: mirror eachElementDo: #init doit:)
				(gEgo setCycle: End self)
			)
			(23
				(gEgo
					view: 0
					looper: Grooper
					setCycle: StopWalk 2
					setMotion: MoveTo 104 146 self
				)
			)
			(24
				(localproc_0)
				(gEgo view: 49 loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(25
				(Print 53 10 #at -1 20 #width 280 #mode 1 #dispose) ; "SIR GRAHAM: "...the magic shield.""
				(= seconds 3)
			)
			(26
				(gAddToPics add: shield eachElementDo: #init doit:)
				(gEgo setCycle: End self)
			)
			(27
				(gEgo
					view: 0
					looper: Grooper
					setCycle: StopWalk 2
					setMotion: MoveTo 137 146 self
				)
			)
			(28
				(localproc_0)
				(gEgo view: 49 loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(29
				(Print 53 11 #at -1 20 #width 280 #mode 1 #dispose) ; "SIR GRAHAM: "...and the magic chest.""
				(= seconds 3)
			)
			(30
				(gAddToPics add: chest eachElementDo: #init doit:)
				(gEgo setCycle: End self)
			)
			(31
				(localproc_0)
				(gEgo
					view: 0
					ignoreActors: 0
					looper: Grooper
					setCycle: StopWalk 2
					setMotion: MoveTo 139 123 self
				)
			)
			(32
				(gEgo view: 5 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(33
				(localproc_0)
				(king cycleSpeed: 2 setCycle: End self)
			)
			(34
				(king
					view: 191
					setLoop: 0
					setCycle: Fwd
					moveSpeed: 2
					setMotion: MoveTo 98 118 self
				)
			)
			(35
				(king setMotion: MoveTo 127 127 self)
			)
			(36
				(king
					view: 191
					cycleSpeed: 1
					loop: 1
					cel: 0
					setPri: 9
					setCycle: CT 3 1 self
				)
			)
			(37
				(king cel: 4 setCycle: End)
				(crown
					init:
					view: 194
					setLoop: 0
					cel: 0
					posn: 160 115
					setCycle: Fwd
					setMotion: MoveTo 180 127 self
				)
			)
			(38
				(crown setCel: 0 setCycle: 0)
				(rs1and2Body setCel: 1)
				(rs2Arm stopUpd: hide:)
				(rs2Head hide:)
				(rs1Head hide:)
				(crowd1 setCel: 1)
				(crowd1Head1 hide:)
				(crowd1Head2 hide:)
				(crowd1Head3 hide:)
				(crowd1Head4 hide:)
				(crowd3 setCel: 1)
				(crowd3Head1 hide:)
				(gEgo setCycle: Beg)
				(doctor setLoop: 1 setCycle: Walk setMotion: MoveTo 98 112 self)
			)
			(39
				(gEgo view: 2 loop: 2)
				(doctor
					moveSpeed: 0
					setStep: 4 2
					setMotion: MoveTo 127 121 self
				)
			)
			(40
				(doctor setMotion: MoveTo 160 121 self)
			)
			(41
				(localproc_0)
				(doctor setLoop: 2 setStep: 3 2 setCycle: End)
				(king view: 193 setLoop: 3 cycleSpeed: 1 setCycle: End self)
			)
			(42
				(talkingHead
					view: 193
					loop: 1
					cel: 0
					description: {king}
					init:
					x: (+ (king x:) 33)
					y: (- (king y:) 9)
					setPri: (+ (king priority:) 1)
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(43
				(Print 53 12 #at -1 20 #width 280 #mode 1 #dispose) ; "KING: "I...I am afraid it is a little too late for me. But you have done superbly, my Knight. As I promised, the kingdom is yours.""
				(= seconds 12)
			)
			(44
				(localproc_0)
				(Print 53 13 #at -1 20 #width 280 #mode 1 #dispose) ; "KING: "I know you will serve her well.""
				(= seconds 6)
			)
			(45
				(localproc_0)
				(talkingHead dispose:)
				(king cycleSpeed: 0 setCycle: Beg self)
			)
			(46
				(king setLoop: 0 setCel: 0 setCycle: 0 stopUpd:)
				(= seconds 2)
			)
			(47
				(doctor setCycle: Beg self)
			)
			(48
				(localproc_0)
				(head
					posn: (+ (doctor x:) 1) (- (doctor y:) 38)
					show:
					setCycle: Fwd
				)
				(Print 53 14 #at -1 20 #width 280 #mode 1 #dispose) ; "DOCTOR: "The King is dead.""
				(= seconds 5)
			)
			(49
				(localproc_0)
				(head hide:)
				(doctor
					setLoop: 1
					ignoreActors:
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 173 121 self
				)
				(rs1and2Body setCel: 0)
				(rs2Arm show: setCycle: 0)
				(rs2Head show:)
				(rs1Head show:)
				(crowd1 setCel: 0)
				(crowd1Head1 show:)
				(crowd1Head2 show:)
				(crowd1Head3 show:)
				(crowd1Head4 show:)
				(crowd3 setCel: 0)
				(crowd3Head1 show:)
			)
			(50
				(doctor setMotion: MoveTo 180 127 self)
			)
			(51
				(doctor setLoop: 2 setCycle: End self)
			)
			(52
				(crown dispose:)
				(doctor setLoop: 3 setCycle: End self)
			)
			(53
				(gEgo view: 5 loop: 1 setCycle: End)
				(doctor
					setLoop: 4
					setCycle: Walk
					setMotion: DPath 173 121 168 123 161 123 self
				)
			)
			(54
				(self setScript: endSongScript)
				(doctor hide:)
				(gEgo view: 192 loop: 5 cel: 0 setCycle: End self)
			)
			(55
				(localproc_0)
				(head
					posn: (+ (gEgo x:) 22) (- (gEgo y:) 39)
					setLoop: 8
					setCycle: Fwd
					show:
				)
				(Print 53 15 #at -1 20 #width 280 #mode 1 #dispose) ; "DOCTOR: "Long live the King!""
				(rs2Arm show: setCycle: Fwd)
				(= seconds 4)
			)
			(56
				(localproc_0)
				(head dispose:)
				(Print 53 16 #at -1 20 #width 280 #mode 1 #dispose) ; "CROWD: "Long live the King!""
				(= seconds 4)
			)
			(57
				(localproc_0)
				(doctor setLoop: 2 cel: 0 show: setCycle: End)
				(gEgo setLoop: 6 setCycle: End)
				(= seconds 2)
			)
			(58
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 99 8)
				(self cue:)
			)
			(59
				(Print 53 17 #dispose) ; "And thus ended Sir Graham's great quest for the lost treasures of Daventry. Despite the loss of their beloved King Edward, the people of Daventry grew happy and prosperous and flourished for years to come."
				(= register 1)
			)
			(60
				(Print 53 18 #dispose) ; "And whenever King Graham looked into his magic mirror, he saw visions of adventures yet to come...for him, for his children, and for Daventry, the land he loved so much."
				(= register 1)
			)
			(61
				(Print 53 19 #dispose) ; "The End."
				(= register 1)
			)
			(62
				(HandsOn)
				(gCurRoom newRoom: 85) ; closeCredits
				(self dispose:)
			)
		)
	)
)

(instance crowdTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(Print 53 20 #at 208 24 #dispose) ; "GASP!"
				(= seconds 2)
			)
			(1
				(localproc_0)
				(Print 53 21 #at 200 24 #dispose) ; "It's Sir Graham!"
				(= seconds 2)
			)
			(2
				(localproc_0)
				(Print 53 22 #at 208 24 #dispose) ; "He's returned!"
				(= seconds 2)
			)
			(3
				(localproc_0)
				(Print 53 23 #at 208 24 #dispose) ; "Did he find the treasures?"
				(= seconds 3)
			)
			(4
				(localproc_0)
				(Print 53 24 #at 208 24 #dispose) ; "Shhhhhh!"
				(= seconds 2)
			)
			(5
				(localproc_0)
				(Print 53 25 #at 208 24 #dispose) ; "Listen!"
				(= seconds 2)
			)
			(6
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance endSongScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 23) loop: 1) ; backSound
				(= cycles 1)
			)
			(1
				((ScriptID 0 23) number: 101 play: self) ; backSound
			)
			(2
				((ScriptID 0 23) number: 102 play: self) ; backSound
			)
			(3
				((ScriptID 0 23) number: 103 play: self) ; backSound
			)
			(4
				(self changeState: 2)
			)
		)
	)
)

(instance head of Prop
	(properties
		view 82
	)
)

(instance shield of PicView
	(properties
		x 90
		y 146
		view 553
		loop 2
		signal 1
	)
)

(instance chest of PicView
	(properties
		x 120
		y 146
		view 553
	)
)

(instance mirror of PicView
	(properties
		x 60
		y 146
		view 553
		loop 1
	)
)

(instance rs1and2Body of View
	(properties
		x 297
		y 128
		description {royal subject}
		view 255
		signal 4
	)
)

(instance rs2Arm of Prop
	(properties
		x 298
		y 97
		description {fan}
		view 255
		loop 1
		priority 10
		signal 20
	)
)

(class TurnHead of Prop
	(properties
		description {person's head}
		view 255
		cel 2
		priority 10
		signal 20
	)

	(method (cue)
		(self stopUpd:)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (< (+ x 8) (gEgo x:)) (< (gEgo x:) 310) (!= cel 0))
				(self setCycle: Beg self)
			)
			(
				(and
					(< (- x 8) (gEgo x:) (+ x 8))
					(< (gEgo x:) 310)
					(!= cel 1)
				)
				(= cel 1)
			)
			((and (< (gEgo x:) (- x 8)) (< (gEgo x:) 310) (!= cel 2))
				(self setCycle: End self)
			)
		)
	)
)

(instance rs1Head of TurnHead
	(properties
		x 289
		y 86
		description {person's head}
		loop 2
	)
)

(instance rs2Head of TurnHead
	(properties
		x 305
		y 93
		description {person's head}
		loop 3
	)
)

(instance crowd1 of View
	(properties
		x 240
		y 136
		description {crowd}
		view 255
		loop 4
		signal 4
	)
)

(instance crowd1Head1 of TurnHead
	(properties
		x 210
		y 93
		description {person's head}
		loop 5
	)
)

(instance crowd1Head2 of TurnHead
	(properties
		x 272
		y 99
		description {person's head}
		loop 8
	)
)

(instance crowd1Head3 of TurnHead
	(properties
		x 250
		y 92
		description {person's head}
		loop 7
	)
)

(instance crowd1Head4 of TurnHead
	(properties
		x 233
		y 98
		description {person's head}
		loop 6
	)
)

(instance crowd2 of PicView
	(properties
		x 253
		y 185
		description {crowd}
		view 253
	)
)

(instance crowd2Part1 of PicView
	(properties
		x 303
		y 175
		description {crowd}
		view 253
		cel 1
	)
)

(instance crowd2Head1 of TurnHead
	(properties
		x 244
		y 147
		description {person's head}
		loop 11
		priority 15
		signal 16404
	)
)

(instance crowd2Head2 of TurnHead
	(properties
		x 263
		y 144
		description {person's head}
		loop 12
		priority 14
		signal 16404
	)
)

(instance crowd2Head3 of TurnHead
	(properties
		x 303
		y 138
		description {person's head}
		loop 13
		priority 13
		signal 16404
	)
)

(instance crowd3 of View
	(properties
		x 264
		y 122
		description {crowd}
		view 255
		loop 9
		signal 4
	)
)

(instance crowd3Head1 of TurnHead
	(properties
		x 266
		y 83
		description {person's head}
		loop 10
	)
)

(instance gramHead of Prop
	(properties
		x 136
		y 95
		view 5
		loop 2
		signal 4
	)

	(method (doVerb))
)

(instance king of Actor
	(properties
		x 81
		y 118
		view 190
		loop 2
		cel 2
		priority 7
		signal 20
	)
)

(instance talkingHead of Prop
	(properties
		x 65
		y 88
		description {king}
		view 190
		loop 1
	)

	(method (doVerb))
)

(instance crown of Actor
	(properties)
)

(instance doctor of Actor
	(properties
		x 94
		y 112
		view 192
		signal 4
	)
)

