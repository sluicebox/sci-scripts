;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use ExitArrow)
(use n045)
(use Print)
(use Talker)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm220 0
	bertTalker 1
)

(local
	local0
	local1
	local2
	local3
)

(instance rm220 of Room
	(properties
		noun 9
		picture 220
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (init)
		(proc45_0)
		(gGame handsOff:)
		(if (!= gDay global157)
			(gPqFlags clear: 167)
			(= global157 gDay)
		else
			(gPqFlags set: 167)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 78 166 319 166 319 163 216 163 229 142 138 142
					yourself:
				)
		)
		(if (== gPrevRoomNum 225)
			(gGlobalSound0 fade: 127 6 2 0)
			(gEgo
				setHeading: 270
				normalize: 9120
				x: 300
				y: 163
				init:
				setScaler: Scaler 120 100 165 136
				setMotion: PolyPath 250 163 self
			)
		else
			(rangeArrow init:)
			(proc0_4 1)
			(gEgo
				setHeading: 90
				normalize: 9120
				x: 113
				y: 152
				setScaler: Scaler 120 100 165 136
				init:
			)
			(if (or (not (gGlobalSound0 handle:)) (!= gPrevRoomNum 210))
				(gGlobalSound0
					number: 1024
					setLoop: -1
					setVol: 0
					play:
					fade: 127 4 2 0
				)
			else
				(gGlobalSound0 setVol: 127)
			)
		)
		(bert
			view: (if (== gPrevRoomNum 225) 223 else 222)
			init:
			approachVerbs: 20 7 5 51 4 50 53 9 1 2 58 ; wallet, ???, ???, ???, Do, ???, ???, ???, Look, Talk, ???
		)
		(box init: approachVerbs: 4) ; Do
		(door init: approachVerbs: 4) ; Do
		(if (gEgo has: 38) ; ammoBox
			(gEgo put: 38) ; ammoBox
		)
		(trophies init:)
		(super init: &rest)
		(if (== gPrevRoomNum 225)
			(= local0 1)
			(self setScript: fromRange)
		else
			(if (== gPrevRoomNum 210)
				(sfx number: 33 loop: 1 play:)
			)
			(self setScript: sEnter)
		)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== newRoomNumber 225)
				(gGlobalSound0 fade: 64 6 2 0)
			)
			((!= newRoomNumber 210)
				(gGlobalSound0 fade: 0 4 2 1)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo x:) 300)
			(cond
				((gEgo has: 37) ; protectors
					(if (!= gPrevRoomNum 225)
						(switch gDay
							(2
								(gPqFlags set: 129)
							)
							(3
								(gPqFlags set: 130)
							)
							(4
								(gPqFlags set: 131)
							)
							(5
								(gPqFlags set: 132)
							)
						)
						(gCurRoom newRoom: 225)
					else
						(gMessager say: 2 2 23) ; "Hey there partner we're going to be closin' soon."
						(gEgo setMotion: 0 x: 299)
					)
				)
				((gEgo has: 38) ; ammoBox
					(if (== gPrevRoomNum 225)
						(gMessager say: 2 2 23) ; "Hey there partner we're going to be closin' soon."
					else
						(gMessager say: 2 2 5) ; "Ya know the rules, cowboy. Headgear required."
					)
					(gEgo setMotion: 0 x: 299)
				)
				(else
					(if (== gPrevRoomNum 225)
						(gMessager say: 2 2 23) ; "Hey there partner we're going to be closin' soon."
					else
						(gMessager say: 2 2 22) ; "Whoa there partner! You aint ready for the range yet."
					)
					(gEgo setMotion: 0 x: 299)
				)
			)
		)
	)
)

(instance rangeArrow of ExitArrow
	(properties
		nsTop 100
		nsLeft 300
		nsBottom 153
		nsRight 319
		exitDir 2
	)
)

(instance box of Feature
	(properties
		noun 1
		nsLeft 261
		nsTop 50
		nsRight 275
		nsBottom 73
		sightAngle 40
		approachX 229
		approachY 142
		approachDist 0
		x 268
		y 140
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((or local0 local1)
						(super doVerb: theVerb)
					)
					((and (== gDay 4) (gEgo has: 2)) ; greenTicket
						(gMessager say: noun 0 24) ; "You have the form you need. Don't be so greedy."
					)
					((and (!= gDay 4) (gEgo has: 46)) ; manilaTicket
						(gMessager say: noun 0 24) ; "You have the form you need. Don't be so greedy."
					)
					(else
						(proc45_1)
						(while 1
							(switch
								(Print
									fore: 0
									addBitmap: 64994 1 0
									font: (if (IsHiRes) 999 else 1999)
									addText: 1 0 6 1 5 2 220 ; "Which form?"
									addButtonBM: 64994 0 0 1 1 0 6 2 12 33 220
									addButtonBM: 64994 0 0 2 1 0 6 3 12 57 220
									init:
								)
								(1
									(if (gEgo has: 2) ; greenTicket
										(gMessager say: 1 0 29) ; "You have that form already."
										(break)
									)
									(if
										(and
											(== gDay 4)
											(not (gEgo has: 46)) ; manilaTicket
										)
										(gGame points: 2 47)
									)
									(gEgo get: 2 setScript: fillOutForms) ; greenTicket
									(break)
								)
								(2
									(if (gEgo has: 46) ; manilaTicket
										(gMessager say: 1 0 29) ; "You have that form already."
										(break)
									)
									(if (not (gEgo has: 2)) ; greenTicket
										(switch gDay
											(2
												(gGame points: 2 45)
											)
											(3
												(gGame points: 2 46)
											)
											(5
												(gGame points: 2 48)
											)
										)
									)
									(gEgo get: 46 setScript: fillOutForms) ; manilaTicket
									(break)
								)
							)
						)
						(proc45_2)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance protectors of View
	(properties
		noun 7
		approachX 188
		approachY 142
		x 209
		y 76
		z 2
		fixPriority 1
		view 224
		loop 2
		signal 16384
	)

	(method (init)
		(= priority (+ (bert priority:) 1))
		(self approachVerbs: 4) ; Do
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo get: 37) ; protectors
				(super doVerb: theVerb)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ammoBox of View
	(properties
		noun 5
		approachX 188
		approachY 142
		x 209
		y 76
		z 2
		fixPriority 1
		view 223
		loop 3
		signal 16384
	)

	(method (init)
		(= priority (+ (bert priority:) 1))
		(self approachVerbs: 4) ; Do
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== gDay 4)
					(gMessager say: 5 1 0) ; "Remmington 9mm 115 grain jacketed hollow points."
				else
					(gMessager say: 5 1 2) ; "CCI Blazer 9mm 115 grain."
				)
			)
			(4 ; Do
				(if (or (== gDay 4) local2)
					(gEgo get: 38) ; ammoBox
					(bert setScript: giveProtectors)
					(self dispose:)
				else
					(gMessager say: 2 2 7) ; "The city ain't rich partner. Pony up!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trophies of Feature
	(properties
		noun 8
		nsLeft 278
		nsTop 29
		nsRight 293
		nsBottom 103
		x 285
		y 29
	)
)

(instance fromRange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(cond
					((== gDay 4)
						(if (gPqFlags test: 164)
							(gMessager say: 2 2 25 0 self) ; "Hey thar, partner! That there was some pretty fancy firin'! Yer score is gonna impress the brass! I'll be sendin' yer results over to yer Lieutenant... ya makin' 'em proud at Parker Center thar, cowboy!"
						else
							(gMessager say: 2 2 26 0 self) ; "Hey thar, partner! You shoot like a school gal! I'll be needin' to send yer results over to your Lieutenant... ya better learn to duck and cover with a score like ya got today!"
						)
					)
					((gPqFlags test: 164)
						(gMessager say: 2 2 27 0 self) ; "That thar was some shootin' cowboy!"
					)
					(else
						(gMessager say: 2 2 28 0 self) ; "Hey thar, partner! Ya better learn to duck and cover with a score like ya got today!"
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance giveForms of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 9126 setLoop: 3 1 cel: 0 setCycle: 0)
				(UpdateScreenItem gEgo)
				(= cycles 3)
			)
			(1
				(gMessager say: 2 register 21 1 self)
			)
			(2
				(cond
					((== gDay 4)
						(if (== register 72)
							(bert view: 226 loop: 0 cel: 0 setCycle: End self)
						else
							(bert view: 225 loop: 0 cel: 0 setCycle: End self)
						)
					)
					((== register 69)
						(bert view: 226 loop: 0 cel: 0 setCycle: End self)
					)
					(else
						(bert view: 225 loop: 0 cel: 0 setCycle: End self)
					)
				)
			)
			(3
				(bert loop: 1 cel: 0 setCycle: End self)
				(gEgo normalize: 9120 3)
			)
			(4
				(cond
					((== gDay 4)
						(if (== register 72)
							(bert loop: 2 cel: 0 setCycle: End self)
						else
							(gEgo put: 2) ; greenTicket
							(self setScript: giveAmmoBox self)
						)
					)
					((== register 69)
						(bert loop: 2 cel: 0 setCycle: End self)
					)
					(else
						(gEgo put: 46) ; manilaTicket
						(self setScript: giveAmmoBox self)
					)
				)
			)
			(5
				(cond
					((== gDay 4)
						(if (== register 72)
							(gMessager say: 2 72 21 2) ; "Whoa, partner. This here is the wrong form. You having trouble seeing color correctly? Maybe you need to review that thar department manual."
							(gEgo view: 9126 setLoop: 3 1 cel: 0 setCycle: 0)
							(UpdateScreenItem gEgo)
							(= cycles 3)
						else
							(self cue:)
						)
					)
					((== register 69)
						(gMessager say: 2 69 21 2 self) ; "Hey now, partner. Ya color blind or somethin'? This here is the wrong form."
						(gEgo view: 9126 setLoop: 3 1 cel: 0 setCycle: 0)
						(UpdateScreenItem gEgo)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				(cond
					((== gDay 4)
						(if (== register 72)
							(gEgo normalize: 9120 3)
							(bert view: 225 loop: 0)
							(bert cel: (bert lastCel:) setCycle: Beg self)
						else
							(gEgo normalize: 9120 3)
							(= local1 1)
							(bert view: 223 loop: 0 cel: 0)
							(gGame handsOn:)
							(self dispose:)
						)
					)
					((== register 69)
						(gEgo normalize: 9120 3)
						(bert view: 225 loop: 0)
						(bert cel: (bert lastCel:) setCycle: Beg self)
					)
					(else
						(gEgo normalize: 9120 3)
						(bert view: 223 loop: 0 cel: 0)
						(= local1 1)
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
			(7
				(gEgo normalize: 9120 3)
				(bert view: 223 loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveProtectors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bert view: 223 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(bert view: 224 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(bert loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(bert view: 223 loop: 0 cel: 0)
				(UpdateScreenItem bert)
				(protectors init:)
				(gGame handsOn:)
			)
		)
	)
)

(instance takeProtectors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 37) ; protectors
				(gMessager say: 2 55 3 0 self) ; "Thank ya, partner."
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fillOutForms of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(= ticks 240)
			)
			(2
				(gMessager say: 1 0 13 0 self) ; "You fill the form out according to department specifications."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveAmmoBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 55 3 0 self) ; "Thank ya, partner."
			)
			(1
				(if caller
					(self cue:)
				else
					(bert view: 223 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(2
				(bert view: 223 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(bert loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(if caller
					(self dispose:)
				)
				(ammoBox init:)
				(gGame handsOn:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bert setCycle: End self)
			)
			(1
				(cond
					((< gDay 4)
						(cond
							((gPqFlags test: 167)
								(gMessager say: 2 2 30 0 self) ; "Howdy, partner! Ya planning on a little practice shootin' today? Or are ya just here ta socialize."
							)
							((== gDay 3)
								(gMessager say: 2 2 16 0 self) ; "Howdy, cowboy! Heard about last night... quite a gunfight!"
							)
							(else
								(gMessager say: 2 2 11 0 self) ; "Howdy, partner! Yer here mighty early. Ya ain't scheduled to qualify until Wednesday! Ya planning on a little practice shootin' today?"
							)
						)
					)
					((== gDay 4)
						(if (gPqFlags test: 167)
							(gMessager say: 2 2 31 0 self) ; "Hello, partner. Ready to qualify this time?"
						else
							(gMessager say: 2 2 10 0 self) ; "Hello, partner, today's the day! Ready to qualify?"
						)
					)
					((gPqFlags test: 167)
						(gMessager say: 2 2 32 0 self) ; "Hello, cowboy, goin' ta do a little shootin' this time?"
					)
					(else
						(gMessager say: 2 2 12 0 self) ; "Hello, cowboy, come by for a little shootin' practice?"
					)
				)
			)
			(2
				(bert setCycle: Beg self)
			)
			(3
				(bert view: 223 setLoop: 0 1 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bertTalker of Narrator
	(properties
		x 85
		y 10
		modeless 2
	)

	(method (startAudio param1)
		(= audModNum (param1 at: 0))
		(= audNoun (param1 at: 1))
		(= audVerb (param1 at: 2))
		(= audCase (param1 at: 3))
		(= audSequence (param1 at: 4))
		(if (ResCheck 146 audModNum audNoun audVerb audCase audSequence) ; CHUNK
			(= ticks (DoAudio audPLAY audModNum audNoun audVerb audCase audSequence))
		)
		(if (and (!= (bert view:) 222) (!= gCurRoomNum 225))
			(bert hide:)
			(bertTalkerHead
				cel: 0
				init:
				setCycle: RandCycle (* (/ ticks 2) 2) 0 1
				cycleSpeed: 10
			)
		)
	)

	(method (dispose)
		(if (and (!= (bert view:) 222) (!= gCurRoomNum 225))
			(bertTalkerHead dispose:)
			(bert show:)
		)
		(super dispose: &rest)
	)
)

(instance bertTalkerHead of Prop
	(properties
		x 209
		y 74
		view 2230
	)
)

(instance bert of Prop
	(properties
		noun 2
		approachX 188
		approachY 142
		x 209
		y 74
		view 222
	)

	(method (doVerb theVerb invItem)
		(if (> argc 1)
			(super doVerb: invItem)
		else
			(gCurRoom setScript: bertScr 0 theVerb)
		)
	)
)

(instance bertScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (gEgo heading:) 45)
					(gEgo setHeading: 45 self)
				else
					(= cycles 2)
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(switch register
					(2
						(switch (++ local3)
							(1
								(gMessager say: 2 2 19 0 self) ; "How are you, Bert?"
							)
							(2
								(gMessager say: 2 2 18 0 self) ; "What's new, Bert?"
							)
							(else
								(gMessager say: 2 2 20 0 self) ; "Feelin' kinda chatty thar, partner? Ya ought ta think about gettin' yerself a filly."
							)
						)
					)
					(69
						(if (not (gEgo has: 11)) ; handgun
							(gMessager say: 2 2 17 0 self) ; "Yer holster is lookin' mighty empty thar, partner. Gonna be damn difficult to hit a target without your piece."
						else
							(gEgo setScript: giveForms 0 69 0 self)
							(self dispose:)
						)
					)
					(72
						(if (not (gEgo has: 11)) ; handgun
							(gMessager say: 2 2 17 0 self) ; "Yer holster is lookin' mighty empty thar, partner. Gonna be damn difficult to hit a target without your piece."
						else
							(gEgo setScript: giveForms 0 72 0 self)
							(self dispose:)
						)
					)
					(20
						(cond
							((or local2 local0)
								(bert doVerb: 0 register)
								(gGame handsOn:)
								(self dispose:)
							)
							(local1
								(if (== gDay 4)
									(gMessager say: 2 2 14 0 self) ; "Quit your foolin', partner. Qualifyin's on the department! That thar ammo is all yer's!"
								else
									(= local2 1)
									(switch gDay
										(2
											(gGame points: 1 49)
										)
										(3
											(gGame points: 1 50)
										)
										(5
											(gGame points: 1 51)
										)
									)
									(gMessager say: 2 2 15 0 self) ; "Thank ya, partner."
								)
							)
							(else
								(bert doVerb: 0 register)
								(gGame handsOn:)
								(self dispose:)
							)
						)
					)
					(55
						(if (gEgo has: 38) ; ammoBox
							(gMessager say: 2 55 4 0 self) ; "Listen, partner, ya need those out on the range. Ya return 'em when yer done shootin'."
						else
							(= next takeProtectors)
							(self dispose:)
						)
					)
					(29
						(if (and local1 (not (gEgo has: 38))) ; ammoBox
							(if (== gDay 4)
								(gMessager say: 2 29 1 0 self) ; "This here time, it's on the department, partner!"
							else
								(gMessager say: 2 29 2 0 self) ; "Ammo costs more than a few pennies unless, of course, ya do your own reloadin'."
							)
						else
							(bert doVerb: 0 20)
							(gGame handsOn:)
							(self dispose:)
						)
					)
					(else
						(bert doVerb: 0 register)
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance door of Feature
	(properties
		noun 4
		nsLeft 20
		nsRight 101
		nsBottom 149
		sightAngle 40
		approachX 113
		approachY 152
		approachDist 0
		x 60
		y 74
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gEgo has: 37) ; protectors
						(gEgo setHeading: 45)
						(gMessager say: 2 2 8) ; "Hey thar, cowboy, ya need to be returning them head gear...."
					)
					((gEgo has: 38) ; ammoBox
						(gEgo setHeading: 45)
						(gMessager say: 2 2 9) ; "Lookit here, partner, that thar ammo's for the range only... any personal firepower ya gotta get elsewhere."
					)
					(else
						(gCurRoom setScript: exitDoorScr)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 310 self)
			)
			(1
				(= ticks 120)
			)
			(2
				(gCurRoom drawPic: -1 10)
				(gCast eachElementDo: #hide)
				(gGlobalSound0 setVol: 60)
				(= ticks 90)
			)
			(3
				(sfx number: 32 loop: 1 play:)
				(= ticks 90)
			)
			(4
				(proc0_4 0)
				(gCurRoom newRoom: 210)
			)
		)
	)
)

