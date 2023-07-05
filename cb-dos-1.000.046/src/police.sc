;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 784)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	police 0
)

(local
	local0
)

(instance police of Rm
	(properties
		picture 128
	)

	(method (init)
		(super init:)
		(HandsOff)
		(Load rsFONT 41)
		(Load rsSOUND 25 54)
		(LoadMany rsPIC 1 85)
		(DrawPic 128 5 1 0)
		(prop1 setCycle: End self init:)
		(prop2 init: hide:)
		(prop3 setPri: 10 init: hide:)
		(prop4 setPri: 10 init: hide:)
		(prop5 init: hide:)
		(prop6 setPri: 11 init: hide:)
	)

	(method (doit)
		(if (== (prop1 view:) 228)
			(cond
				((< (prop1 cel:) 2)
					(prop1 cycleSpeed: 1)
				)
				((< (prop1 cel:) 5)
					(prop1 cycleSpeed: 2)
				)
				(else
					(prop1 cycleSpeed: 0)
					(if (and (!= (gConMusic number:) 25) (not local0))
						(= local0 1)
						(gConMusic number: 25 loop: 1 play:)
					)
				)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (cue)
		(police curPic: 1)
		(DrawPic 1 5 1 1)
		(gAddToPics add: boat policeman doit:)
		(prop1
			view: 111
			loop: 4
			posn: 105 118
			setPri: 12
			setCycle: Fwd
			setScript: PoliceEscort
		)
		(prop5 stopUpd: show:)
		(Display 784 0 dsCOORD 116 0 dsWIDTH 240 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0) ; "The next morning..."
	)
)

(instance CEyeActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(CEye show:)
				(= cycles 1)
			)
			(1
				(CEye hide:)
				(= state -1)
				(= seconds (Random 3 6))
			)
		)
	)
)

(instance LEyeActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LEye cel: 1 show:)
				(= cycles 1)
			)
			(1
				(LEye hide:)
				(= state -1)
				(= seconds (Random 3 6))
			)
		)
	)
)

(instance COEyeActions of Script
	(properties)

	(method (doit)
		(switch (prop3 loop:)
			(4
				(COEye posn: 145 94 cel: 0)
			)
			(6
				(COEye posn: 150 95 cel: 1)
			)
			(7
				(COEye posn: 147 97 cel: 2)
			)
			(else
				(COEye hide:)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(COEye show:)
				(= cycles 1)
			)
			(1
				(COEye hide:)
				(= state -1)
				(= seconds (Random 3 6))
			)
		)
	)
)

(instance PoliceEscort of Script
	(properties)

	(method (doit)
		(if (== (self state:) 4)
			(prop1 posn: (- (actor1 x:) 4) (- (actor1 y:) 35) show:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actor1 setCycle: Walk setMotion: MoveTo 150 86 self init:)
				(actor2
					setLoop: 7
					setCycle: Walk
					setMotion: MoveTo 135 84
					init:
				)
				(gConMusic number: 54 loop: 1 play:)
			)
			(1
				(actor1 setMotion: MoveTo 176 127 self)
				(actor2 setMotion: MoveTo 167 125)
			)
			(2
				(gCast eachElementDo: #hide)
				(cls)
				(gAddToPics dispose:)
				(police curPic: 85)
				(DrawPic 85 6 1 0)
				(prop2 show:)
				(prop3 loop: 4 setCycle: Fwd show:)
				(prop4 show:)
				(prop6 show:)
				(Print 784 1 #at 62 135 #dispose) ; "I somehow knew that one day Rudy would run afoul of the law."
				(= seconds 4)
			)
			(3
				(prop3 cel: 0 setCycle: 0)
				(= cycles 2)
			)
			(4
				(gCast eachElementDo: #hide)
				(cls)
				(police curPic: 1)
				(DrawPic 1 7 1 1)
				(prop5 setCycle: End show:)
				(prop1 loop: 5)
				(actor1
					view: 111
					setLoop: 1
					setCel: 0
					posn: 25 151
					show:
					setMotion: MoveTo -64 151 self
				)
				(actor2
					view: 111
					setLoop: 6
					posn: 88 147
					show:
					setMotion: MoveTo -1 147
				)
			)
			(5
				(gCast eachElementDo: #hide)
				(police curPic: 85)
				(DrawPic 85 6 1 0)
				(prop2 show:)
				(prop3 loop: 5 cel: 0 cycleSpeed: 1 setCycle: End self show:)
				(prop4 show:)
				(prop6 show:)
				(CEye setPri: 14 init: setScript: CEyeActions)
				(LEye setPri: 14 init: setScript: LEyeActions)
				(COEye setPri: 14 init: setScript: COEyeActions)
			)
			(6
				(prop3 loop: 6 cycleSpeed: 0 setCycle: Fwd)
				(Print 784 2 #at 62 135 #dispose) ; "You've been a loyal servant to me for many years, Celie. And both Beauregard and Blaze trust you."
				(= seconds 8)
			)
			(7
				(Print 784 3 #at 20 135 #width 280 #dispose) ; "I've decided to leave all my money to you...PROVIDED you take care of my animals for the rest of their lives."
				(= seconds 8)
			)
			(8
				(prop3 setCel: 0)
				(Print 784 4 #at 62 135 #dispose) ; "Course, suh. I cain't think of nothin' else I'd rather do. Thank ya, suh."
				(prop4 setCycle: Fwd)
				(= seconds 8)
			)
			(9
				(prop3 loop: 5)
				(prop3
					cel: (- (NumCels prop3) 1)
					cycleSpeed: 1
					setCycle: Beg self
				)
				(prop4 setCel: 0)
			)
			(10
				(if (gEgo has: 22) ; pouch
					(LEye show: loop: 3 cel: 0 setScript: 0)
				)
				(prop3 loop: 0 setCycle: End self)
			)
			(11
				(prop3 loop: 4 cel: 0 cycleSpeed: 0 setCycle: Fwd)
				(if (gEgo has: 22) ; pouch
					(Print 784 5 #at 62 135 #dispose) ; "Miss Bow, I know you found an old Civil War treasure on my estate."
					(= seconds 8)
				else
					(= state 13)
					(= cycles 1)
				)
			)
			(12
				(Print 784 6 #at 62 135 #dispose) ; "Since you so bravely saved my life, I'll let you keep every dime of it for yourself...as a reward."
				(= seconds 8)
			)
			(13
				(prop3 setCel: 0)
				(LMouth cycleSpeed: 0 setPri: 14 setCycle: Fwd init:)
				(Print 784 7 #at 62 135 #dispose) ; "Thank you, Colonel Dijon. That's very kind of you."
				(= seconds 6)
			)
			(14
				(if (gEgo has: 22) ; pouch
					(LEye setScript: LEyeActions)
					(LMouth hide:)
				)
				(prop3 loop: 7 cel: 0 cycleSpeed: 0 setCycle: Fwd)
				(prop5
					view: 185
					loop: 9
					cel: 0
					posn: 109 138
					setPri: 10
					cycleSpeed: 1
					setCycle: Fwd
					show:
				)
				(prop6 cycleSpeed: 1 setCycle: End)
				(Print 784 8 #at 62 20 #dispose) ; "You know, Beauregard, people are funny creatures. They're greedy, they're rude, they're selfish."
				(= seconds 8)
			)
			(15
				(prop6 stopUpd:)
				(Print 784 9 #at 20 20 #width 280 #dispose) ; "That's why we live way out here, to get away from them. But we couldn't get away from them completely, could we, boy?"
				(= seconds 8)
			)
			(16
				(Print 784 10 #at 62 20 #dispose) ; "No, not completely. But, everything will be okay, now."
				(= seconds 6)
			)
			(17
				(cls)
				(prop3 setCel: 0)
				(Display 784 11 dsCOORD 157 43 dsWIDTH 50 dsCOLOR 6 dsBACKGROUND -1 dsFONT 41) ; "The End"
				(Display 784 11 dsCOORD 156 41 dsWIDTH 50 dsCOLOR 14 dsBACKGROUND -1 dsFONT 41) ; "The End"
				(= seconds 4)
				(gConMusic fade:)
			)
			(18
				(gCurRoom newRoom: 786) ; SlthOMtr
			)
		)
	)
)

(instance boat of PV
	(properties
		y 153
		x 101
		view 111
	)
)

(instance policeman of PV
	(properties
		y 130
		x 147
		view 111
		cel 1
		priority 12
	)
)

(instance prop1 of Prop
	(properties
		y 47
		x 164
		view 228
	)
)

(instance prop2 of Prop
	(properties
		y 62
		x 121
		view 185
		loop 1
	)
)

(instance prop3 of Prop
	(properties
		y 112
		x 153
		view 185
	)
)

(instance prop4 of Prop
	(properties
		y 65
		x 227
		view 285
		loop 2
	)
)

(instance prop5 of Prop
	(properties
		y 74
		x 129
		view 54
		cycleSpeed 1
	)
)

(instance prop6 of Prop
	(properties
		y 136
		x 84
		view 285
		loop 3
	)
)

(instance actor1 of Act
	(properties
		y 86
		x 150
		view 394
	)
)

(instance actor2 of Act
	(properties
		y 84
		x 135
		view 111
	)
)

(instance CEye of Prop
	(properties
		y 50
		x 217
		view 285
	)
)

(instance LEye of Prop
	(properties
		y 43
		x 114
		view 185
		loop 3
	)
)

(instance LMouth of Prop
	(properties
		y 53
		x 115
		view 185
		loop 8
	)
)

(instance COEye of Prop
	(properties
		y 50
		x 217
		view 185
		loop 2
	)
)

