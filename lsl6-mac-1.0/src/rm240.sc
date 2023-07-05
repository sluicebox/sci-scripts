;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use n079)
(use OccCyc)
(use LarryRoom)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm240 0
	kenny 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm240 of LarryRoom
	(properties
		noun 1
		picture 240
		horizon 0
		autoLoad 0
	)

	(method (init)
		((ScriptID 0 11) init: self) ; iconExit
		(gGame handsOn:)
		(= local0
			((Polygon new:) type: PTotalAccess init: 105 24 120 30 83 48 65 42 yourself:)
		)
		(= local1
			((Polygon new:) type: PTotalAccess init: 84 64 128 82 111 93 66 72 yourself:)
		)
		(= local2
			((Polygon new:) type: PTotalAccess init: 196 55 217 57 178 82 157 75 yourself:)
		)
		(super init: &rest)
		((ScriptID 0 11) init: 230) ; iconExit
		(if (or (== gPrevRoomNum 250) (== (gEgo view:) 239))
			(merrily
				init:
				setPri: 8
				ignoreActors: 1
				setScript: rubLotion
				stopUpd:
			)
			(merrilyBottom
				init:
				ignoreActors: 1
				cycleSpeed: 18
				setCycle: Fwd self 1 5 30
			)
			(kenny
				init:
				setScript: randomKenny
				ignoreActors: 1
				cycleSpeed: 15
				setCycle: Fwd self 1 5 30
			)
			(kennyBottom init: ignoreActors: 1 stopUpd:)
			(if (== gPrevRoomNum 250)
				(gEgo
					view: 243
					loop: 0
					cel: 0
					x: 97
					y: 117
					actions: egoActions
					init:
				)
				(egoTail
					init:
					ignoreActors: 1
					cycleSpeed: 16
					setCycle: Fwd self 1 5 30
				)
				(gGame handsOn:)
			else
				(gCurRoom setScript: rideBeaverIn)
			)
		else
			(barEdge init: signal: -4097 ignoreActors: 1 addToPic:)
			(waterProp1 init: setCycle: RandOccCycle self 1 10 120)
			(waterProp2 init: setCycle: RandOccCycle self 1 10 120)
			((ScriptID 0 11) init: 230) ; iconExit
			(gGame handsOn:)
		)
		(cashRegister init:)
		(tipJar init:)
		(poolBar init:)
		(barSign init:)
		(counterTops init:)
		(if (not (IsFlag 168))
			(sunglassCase init:)
		)
	)

	(method (cue)
		(if (gCurRoom script:)
			(kennyTimer setReal: gCurRoom (Random 5 15))
		else
			(gCurRoom setScript: talkToKenny)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not (gCast contains: merrily))
					(gMessager say: 1 1 3) ; "La Costa Lotta's unique freely floating swimming pool bar has conveniently floated over near the edge of the pool. It's so close, you can reach out and touch it (probably without getting wet)."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(if (not (gCast contains: merrily))
					(gMessager say: 1 0 3) ; "The bar should be open some time soon, perhaps later in the day, when you swim your daily laps."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (dispose)
		(ClearFlag 40)
		(local0 dispose:)
		(local1 dispose:)
		(local2 dispose:)
		((ScriptID 0 11) dispose:) ; iconExit
		(if (== (gEgo view:) 243)
			(gEgo view: 239)
		)
		(waitressTimer delete: dispose:)
		(super dispose:)
	)
)

(instance randomKenny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kennyBottom setCycle: End self)
			)
			(1
				(= seconds 3)
			)
			(2
				(kennyBottom setCycle: Beg self)
			)
			(3
				(= seconds (Random 5 15))
			)
			(4
				(kennyBottom loop: 5 cycleSpeed: 15 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(kennyBottom setCycle: 0 loop: 2 setCel: 0 stopUpd:)
				(= seconds (Random 10 20))
			)
			(6
				(self init:)
			)
		)
	)
)

(instance rubLotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 0 15))
			)
			(1
				(merrily loop: 9 setCel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(2
				(= ticks 30)
			)
			(3
				(merrily loop: 10 setCycle: Fwd)
				(= seconds 7)
			)
			(4
				(merrily loop: 11 setCel: 0 setCycle: End self)
			)
			(5
				(merrily loop: 12 setCel: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(6
				(merrily setCycle: 0 loop: 8 setCel: 0 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance rideBeaverIn of Script
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (gEgo cel:))
		(if (and (not (sFx handle:)) (== temp0 2))
			(sFx number: 233 loop: 1 play:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 243
					setLoop: 6
					setSpeed: 6
					cel: 0
					x: 0
					y: 117
					actions: egoActions
					init:
					setCycle: Walk
					setMotion: MoveTo 97 117 self
				)
			)
			(1
				(gEgo loop: 2 setCel: 1 setCycle: Beg self)
			)
			(2
				(gEgo loop: 0 cel: 0)
				(egoTail init: ignoreActors: 1 cycleSpeed: 15 setCycle: Fwd)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance slapTail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 5 4 0 0 self) ; "You decide to order a drink..."
			)
			(1
				(gEgo loop: 2 setSpeed: 12 setCel: 0 setCycle: End self)
				(egoTail hide:)
			)
			(2
				(gEgo loop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(sFx number: 233 loop: 1 play: 127)
				(gEgo setCycle: End self)
			)
			(4
				(sFx number: 233 loop: 1 play: 127)
				(gEgo setCycle: End self)
			)
			(5
				(sFx number: 233 loop: 1 play: 127)
				(= ticks 30)
			)
			(6
				(gEgo loop: 0 setCycle: 0 setCel: 0)
				(egoTail show:)
				(= seconds 5)
			)
			(7
				(if (gCast contains: waitress)
					(gGame handsOn:)
					(self dispose:)
				)
				(waitress view: 2423 init: loop: 1 setCel: 0 setCycle: End self)
			)
			(8
				(waitress view: 242 loop: 0 setCycle: Fwd)
				(gMessager say: 9 0 9 1 3 self) ; "Yes, sir? You slapped?"
			)
			(9
				(waitressTimer setReal: waitress 30)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToKenny of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 40))
					(gMessager say: 3 2 0 1 3 self) ; "So, how do you order a drink here, stranger?"
				else
					(self cue:)
				)
			)
			(1
				(if (IsFlag 40)
					(gMessager say: 3 2 0 4 self) ; "...blah, blah, blah, blah, blah..."
				else
					(self cue:)
				)
			)
			(2
				(= temp0 (Random 1 21))
				(gMessager say: 3 2 12 temp0 self)
			)
			(3
				(gMessager say: 3 2 0 5 self) ; "Ha, ha, ha, ha, ha!"
			)
			(4
				(SetFlag 40)
				(kennyTimer setReal: gCurRoom (Random 5 15))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance orderDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(waitressTimer dispose:)
				(gEgo
					view: 243
					loop: 7
					setCel: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(1
				(= ticks 180)
			)
			(2
				(gGame changeScore: 10 169)
				(gEgo setCycle: Beg self)
			)
			(3
				(if local4
					(gMessager say: 9 51 9 0 self) ; "Ah, yes, Mr. Thomas, sir! I remember your room number from last week. All the girls were talking about the quantity of beverages you ordered. What would you like?"
				else
					(self cue:)
				)
			)
			(4
				(gMessager say: 9 7 9 0 self) ; "Ah, yes sir! What would you like?"
			)
			(5
				(waitress view: 2422 loop: 0 setCel: 0 setCycle: End self)
			)
			(6
				(waitress loop: 1 setCel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(7
				(waitress
					view: 2423
					setCycle: 0
					loop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(8
				(= ticks 310)
			)
			(9
				(waitress view: 2423 loop: 2 setCel: 0 setCycle: End self)
			)
			(10
				(waitress view: 2421 loop: 3 setCel: 0 setCycle: End self)
			)
			(11
				(glass2 init: setPri: 6 ignoreActors: 1)
				(waitress loop: 2 setCel: 0 setCycle: End self)
			)
			(12
				(glass1 init: setPri: 6 ignoreActors: 1)
				(waitress view: 242 loop: 0 setCycle: Fwd)
				(= cycles 2)
			)
			(13
				(gMessager say: 9 0 10 1 3 self) ; "Here you are, Sir! That will be $50.00."
			)
			(14
				(glass1 hide:)
				(gEgo view: 243 loop: 4 setCel: 0 setCycle: End self)
				(merrily loop: 13 setCel: 0 setCycle: CT 2 1 self)
			)
			(15
				(glass2 hide:)
				(merrily setCycle: End)
			)
			(16
				(gEgo loop: 5 setCel: 0 setCycle: End self)
			)
			(17
				(merrily loop: 14 setCel: 0 setCycle: End self)
			)
			(18
				(gEgo loop: 4 setCel: 4 setCycle: Beg self)
			)
			(19
				(= cycles 1)
			)
			(20
				(glass1 show:)
				(gEgo view: 243 loop: 0 cel: 0)
				(= cycles 10)
			)
			(21
				(gMessager say: 9 0 10 4 5 self) ; "(SLURPING SOUND) Hey! These drinks are "watered down!""
			)
			(22
				(= ticks 120)
			)
			(23
				(waitress view: 2423 loop: 0 setCel: 0 setCycle: End self)
				(merrily setCycle: Beg)
			)
			(24
				(merrily loop: 13 setCel: 6 setCycle: CT 2 -1 self)
				(waitress dispose:)
				(gGame handsOn:)
			)
			(25
				(glass2 show: stopUpd:)
				(merrily setCycle: Beg self)
			)
			(26
				(merrily view: 241 loop: 8 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance waitressLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 9 0 9 4 self) ; "I'm sorry, but if you have no proof of your status here, I'll be unable to fill your order."
			)
			(1
				(waitress view: 2423 loop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(waitress dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getGlasses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 8 5 0 1 2 self) ; "Sneaking over to the edge of the pool and leaning way out, you inquire about that pair of sunglasses lying on the bar..."
			)
			(2
				(gGame changeScore: 7 168)
				(sunglassCase hide:)
				(gEgo get: 30) ; glasscase
				(= cycles 10)
			)
			(3
				(gMessager say: 8 5 0 3 self) ; "Guess they're mine now."
			)
			(4
				(gGame handsOn:)
				(sunglassCase dispose:)
				(self dispose:)
			)
		)
	)
)

(instance toCU of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 102))
					(gMessager say: 2 2 11 0 self) ; "I couldn't help but notice you "hanging out" here at the pool bar. Allow me to introduce myself: my name is Larry; Larry Laffer."
				else
					(self cue:)
				)
			)
			(1
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance barSign of Feature
	(properties
		noun 12
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 113 13 108 0 142 0 142 9
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance counterTops of Feature
	(properties
		y 69
		noun 13
	)

	(method (onMe param1)
		(return
			(or
				(AvoidPath (param1 x:) (param1 y:) local0)
				(AvoidPath (param1 x:) (param1 y:) local1)
				(AvoidPath (param1 x:) (param1 y:) local2)
			)
		)
	)
)

(instance poolBar of Feature
	(properties
		noun 4
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 53 65 64 47 64 41 105 24 111 26 159 21 160 27 204 35 217 33 228 38 228 64 208 86 156 111 118 111 91 104 54 78 53 66
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(if (gCast contains: egoTail)
					(gMessager say: 4 4 1) ; "You slide your hand along the plastic laminate bar and admire its finish."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(if (gCast contains: egoTail)
					(gMessager say: 4 1 1) ; "From your position in the water, you can appreciate the fine craftsmanship that went into the building of such a goofy device."
				else
					(gMessager say: 4 1 3) ; "The bar is made of the finest imported plastic laminate, but has warped considerably from the heavily chlorinated water."
				)
				(return 1)
			)
			(2 ; Talk
				(if (gCast contains: egoTail)
					(gMessager say: 4 2 1) ; "Who do you have to know to get a drink around here?"
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cashRegister of Feature
	(properties
		noun 11
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 162 24 169 5 186 6 185 24 173 28 162 25
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tipJar of Feature
	(properties
		noun 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 204 12 214 12 214 30 204 30
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance egoTail of Prop
	(properties
		x 97
		y 117
		noun 5
		view 243
		loop 1
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 169)
					(gMessager say: 5 4 11) ; "After your first experience with these drinks, you decide never to slap your tail here again."
				else
					(gCurRoom setScript: slapTail)
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((== (= temp0 (self cel:)) 2)
				(gEgo posn: 97 119)
				(egoTail posn: 97 119)
			)
			((== temp0 3)
				(gEgo posn: 97 118)
				(egoTail posn: 97 118)
			)
			((== temp0 0)
				(gEgo posn: 97 117)
				(egoTail posn: 97 117)
			)
			((== temp0 1)
				(gEgo posn: 97 118)
				(egoTail posn: 97 118)
			)
		)
		(super doit: &rest)
	)
)

(instance waitress of Prop
	(properties
		x 139
		y 71
		noun 9
		view 242
		loop 3
	)

	(method (cue)
		(if (gCurRoom script:)
			(waitressTimer setReal: waitress 5)
		else
			(self setScript: waitressLeaves)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 52 51) ; randomKey [ filed ], randomKey
				(= local4 1)
				(gCurRoom setScript: orderDrink)
			)
			(7 ; roomkey
				(gCurRoom setScript: orderDrink)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance merrily of Prop
	(properties
		x 198
		y 106
		noun 2
		view 241
		loop 8
		cel 2
	)

	(method (doVerb theVerb)
		(if (and (IsFlag 169) (OneOf theVerb 1 4 2)) ; Look, Do, Talk
			(gCurRoom setScript: toCU)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance merrilyBottom of Prop
	(properties
		x 198
		y 106
		noun 6
		view 241
		loop 7
	)

	(method (doit &tmp temp0)
		(cond
			((== (= temp0 (self cel:)) 2)
				(merrily posn: 198 108)
				(merrilyBottom posn: 198 108)
			)
			((== temp0 3)
				(merrily posn: 198 107)
				(merrilyBottom posn: 198 107)
			)
			((== temp0 0)
				(merrily posn: 198 106)
				(merrilyBottom posn: 198 106)
			)
			((== temp0 1)
				(merrily posn: 198 107)
				(merrilyBottom posn: 198 107)
			)
		)
		(super doit: &rest)
	)
)

(instance kenny of Prop
	(properties
		x 20
		y 49
		noun 3
		view 241
		loop 1
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local3)
					(gMessager say: 3 4 4) ; "There's nothing you want to do to him. Except not start him telling jokes!"
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(if (not local3)
					(gMessager say: 3 1 4) ; "A male customer sits at the other side of the bar, riding an inflatable pussy, quietly drinking by himself. He seems to be no match for you in your quest to finally "net" yourself a catch like that babe on the cucumber!"
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(2 ; Talk
				(= local3 1)
				(gCurRoom setScript: talkToKenny)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((== (= temp0 (self cel:)) 1)
				(kenny posn: 20 50)
				(kennyBottom posn: 20 50)
			)
			((== temp0 2)
				(kenny posn: 20 51)
				(kennyBottom posn: 20 51)
			)
			((== temp0 3)
				(kenny posn: 20 50)
				(kennyBottom posn: 20 50)
			)
			((== temp0 0)
				(kenny posn: 20 49)
				(kennyBottom posn: 20 49)
			)
		)
		(super doit: &rest)
	)
)

(instance kennyBottom of Prop
	(properties
		x 20
		y 49
		noun 3
		view 241
	)

	(method (doVerb theVerb)
		(kenny doVerb: theVerb)
	)
)

(instance barEdge of View
	(properties
		y 139
		view 244
	)
)

(instance sunglassCase of View
	(properties
		x 88
		y 70
		noun 8
		view 240
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Take
				(gCurRoom setScript: getGlasses)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance glass1 of View
	(properties
		x 114
		y 81
		view 240
	)
)

(instance glass2 of View
	(properties
		x 183
		y 68
		view 240
	)
)

(instance waterProp1 of Prop
	(properties
		x 147
		y 66
		view 245
		cel 4
		cycleSpeed 25
	)
)

(instance waterProp2 of Prop
	(properties
		x 142
		y 109
		view 245
		loop 1
		cel 4
		cycleSpeed 25
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 169)
					(gMessager say: 5 4 11) ; "After your first experience with these drinks, you decide never to slap your tail here again."
				else
					(gCurRoom setScript: slapTail)
				)
				(return 1)
			)
			(1 ; Look
				(egoTail doVerb: theVerb)
				(return 1)
			)
			(2 ; Talk
				(egoTail doVerb: theVerb)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance waitressTimer of Timer
	(properties)
)

(instance kennyTimer of Timer
	(properties)
)

(instance sFx of Sound
	(properties)
)

