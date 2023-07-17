;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 275)
(include sci.sh)
(use Main)
(use TellerIcon)
(use SyncedView)
(use Inset)
(use Talker)
(use Scaler)
(use ROsc)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Rev)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm275 0
	samTalker 1
	sherryTalker 2
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm275 of Room
	(properties
		noun 1
		picture 275
	)

	(method (init)
		(gGame handsOff:)
		(if (== gPrevRoomNum 240)
			(= gDay 5)
			(proc0_4 1)
		)
		(super init: &rest)
		(if (== gDay 2)
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 48 152 319 152 319 110 310 110 310 122 245 122 234 118 139 118 139 121 233 121 240 133 192 145 161 145 110 137 69 146
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 48 152 319 152 319 110 310 110 310 122 245 122 234 118 139 118 139 121 233 121 233 135 192 145 161 145 110 137 69 146
						yourself:
					)
			)
		)
		(if (IsHiRes)
			(hiResSkel1 init:)
			(hiResSkel2 init:)
			(hiResSink init:)
		)
		(shelves init:)
		(counter init:)
		(sink init: approachVerbs: 1) ; Look
		(door init: approachVerbs: 4) ; Do
		(theScale init:)
		(largeWindow init:)
		(poster init:)
		(posterLeft init:)
		(exTable init:)
		(musicThing init:)
		(knives init: approachVerbs: 1) ; Look
		(switch gDay
			(2
				(if (not (gPqFlags test: 9))
					(gEgo
						setHeading: 225
						normalize: 0
						posn: 313 122
						setTalker: egoTalker
						setScaler: Scaler 141 53 189 69
						init:
					)
					(sam
						posn: 153 128
						view: 285
						loop: 0
						cel: 6
						init:
						approachX: 163
						approachY: 150
						approachVerbs: 2 52 ; Talk, notebook
					)
					(hickman init: approachVerbs: 52) ; notebook
					(self setScript: lookBody)
				else
					(gEgo
						setHeading: 225
						normalize: 0
						posn: 313 122
						setTalker: egoTalker
						setScaler: Scaler 141 53 189 69
						init:
					)
					(gGame handsOn:)
				)
			)
			(3
				(gEgo
					setHeading: 225
					normalize: 0
					posn: 313 122
					setTalker: egoTalker
					setScaler: Scaler 141 53 189 69
					init:
				)
				(sam
					posn: 158 137
					view: 284
					loop: 0
					cel: 0
					setPri: 130
					init:
					approachX: 146
					approachY: 143
					approachVerbs: 2 52 ; Talk, notebook
				)
				(self setScript: scrubTable)
			)
			(4
				(gEgo
					setHeading: 225
					normalize: 0
					posn: 313 122
					setTalker: egoTalker
					setScaler: Scaler 141 53 189 69
					init:
				)
				(if (gEgo has: 23) ; boneBaggie
					(switch global123
						(0
							(sam
								posn: 151 139
								view: 283
								loop: 0
								cel: 0
								init:
								approachX: 277
								approachY: 145
								approachVerbs: 2 52 ; Talk, notebook
							)
							(sherry setPri: 138 init:)
							(self setScript: checkSherry)
						)
						(2
							(sam
								posn: 151 139
								view: 2750
								loop: 0
								cel: 0
								setLooper: Grooper
								setCycle: StopWalk 276
								setHeading: 90
								init:
								approachX: 212
								approachY: 139
								approachVerbs: 2 52 ; Talk, notebook
								setScript: samGoesOff
							)
							(gGame handsOn:)
						)
						(3
							(sam
								posn: 151 139
								view: 2750
								loop: 0
								cel: 0
								setLooper: Grooper
								setCycle: StopWalk 276
								setHeading: 90
								init:
								approachX: 212
								approachY: 139
								approachVerbs: 2 52 ; Talk, notebook
							)
							(gGame handsOn:)
						)
					)
				else
					(sam
						posn: 194 126
						view: 282
						loop: 0
						cel: 0
						init:
						approachX: 146
						approachY: 143
						approachVerbs: 2 52 ; Talk, notebook
					)
					(self setScript: washHands)
				)
			)
			(5
				(if (gPqFlags test: 99)
					(gEgo
						setHeading: 225
						normalize: 0
						posn: 313 122
						setTalker: egoTalker
						setScaler: Scaler 141 53 189 69
						init:
					)
					(sam
						posn: 194 126
						view: 282
						loop: 0
						cel: 0
						init:
						approachX: 146
						approachY: 143
						approachVerbs: 2 52 ; Talk, notebook
					)
					(self setScript: washHands)
				else
					(gPqFlags set: 99)
					(gEgo
						posn: 220 151
						heading: 315
						normalize: 0
						setScaler: Scaler 141 53 189 69
						init:
					)
					(sam
						posn: 139 140
						view: 2750
						loop: 4
						cel: 0
						setLooper: Grooper
						setCycle: StopWalk 276
						init:
						approachVerbs: 2 52 ; Talk, notebook
					)
					(sherry
						view: 287
						posn: 175 129
						loop: 0
						cel: 0
						setPri: 138
						init:
					)
					(self setScript: yellSherry)
				)
			)
			(else
				(gEgo
					setHeading: 225
					normalize: 0
					posn: 313 122
					setTalker: egoTalker
					setScaler: Scaler 141 53 189 69
					init:
				)
				(sam init: approachVerbs: 2 52) ; Talk, notebook
				(gGame handsOn:)
			)
		)
		(if (gCast contains: sam)
			(samTeller init: sam 275)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((< (gEgo y:) 118)
				(self newRoom: 270)
			)
		)
	)

	(method (dispose)
		(gGlobalSound2 number: 0 stop:)
		(super dispose:)
	)
)

(instance comeInWash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 146 143 self)
			)
			(1
				(Face gEgo sam)
				(= ticks 180)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance washHands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sam setCycle: CT 8 1 self)
				(gEgo setScript: comeInWash)
			)
			(1
				(Load rsVIEW 282)
				(sam setCycle: ROsc -1 6 8)
				(= ticks 420)
			)
			(2
				(sam view: 282 loop: 1 cel: 0 setCycle: CT 11 1 self)
			)
			(3
				(gMessager say: 2 2 13 1 self) ; "Hello, John."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setScript: comeInWash self)
			)
			(1
				(sam cel: 0)
				(gMessager say: 2 2 13 1 self) ; "Hello, John."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance scrubTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((= local4 (Prop new:))
					view: 284
					loop: 2
					cel: 0
					name: {samArm}
					posn: (sam x:) (sam y:)
					ignoreActors:
					init:
					setCycle: Osc -1
				)
				(sam setCycle: Osc -1)
				(gEgo setScript: comeInWash self)
			)
			(1
				(sam setCycle: End self)
				(local4 setCycle: End)
			)
			(2
				(local4 hide:)
				(sam loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 2 2 13 1 self) ; "Hello, John."
			)
			(4
				(if (gPqFlags test: 11)
					(gMessager say: 2 2 54 1 self) ; "Is there anything else I can do for you, John?"
				else
					(gMessager say: 2 2 45 1 self) ; "John, why don't you join Chester and me at the Short Stop tonight. I'll buy you a cold one. You look like you could use it."
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance day2Greet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gPqFlags set: 11)
				(gMessager say: 2 2 13 2 self) ; "Hello, Sam."
			)
			(1
				(if (and (not (gPqPointFlags test: 6)) (not (gPqFlags test: 8)))
					(gPqFlags set: 8)
					(gMessager say: 2 2 1 0 self) ; "It's been a bad morning John, very bad indeed. The body of a black youth, approximately seven years of age, was brought in very early."
				else
					(self cue:)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance day3Greet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gPqFlags set: 11)
				(gMessager say: 2 2 45 2 self) ; "Thanks Sam, it sounds good. I'll try and make it..."
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance day4Greet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gPqFlags set: 11)
				(gMessager sayRange: 2 2 13 2 4 self) ; "Hello, Sam."
			)
			(1
				(gGame handsOn:)
				(= seconds 10)
			)
			(2
				(gMessager say: 2 2 30 1 self) ; "John, what can I help you with?"
			)
			(3
				(self changeState: (- state 2))
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance yellSherry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(Load rsVIEW 288)
				(gMessager sayRange: 2 2 55 1 5 self) ; "Sherry, what you did last night, by talking to the press, caused citywide panic! Do you understand that?!"
			)
			(2
				(sherry
					setSpeed: 1
					view: 288
					loop: 0
					cel: 0
					posn: 178 141
					setCycle: End self
				)
			)
			(3
				(sherry
					setLoop: 1 1
					cel: 0
					setCycle: End self
					setMotion: MoveTo 173 148 self
				)
			)
			(4 0)
			(5
				(sherry setLoop: -1 loop: 2 setCycle: End self)
			)
			(6
				(LoadMany rsVIEW 2900 289)
				(gMessager say: 2 2 55 6 self) ; "Honest, Detective Carey, I didn't mean to cause any trouble. I wouldn't hurt a fly, even if it was flying around and like, you know, buzzing in my ear! Honest!"
			)
			(7
				(sherry
					heading: 180
					view: 2900
					loop: 2
					posn: 176 145
					setLooper: Grooper
					origStep: 771
					setScaler: Scaler 100 74 145 95
					setCycle: StopWalk 289
					setMotion: PolyPath 310 122 self
				)
			)
			(8
				(sherry setPri: -1 setMotion: DPath 310 115 278 115 self)
				(sam approachX: 212 approachY: 139)
			)
			(9
				(= cycles 1)
			)
			(10
				(gMessager say: 2 2 55 7 self) ; "John, how can you be mad at a girl like that?"
			)
			(11
				(sherry dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance checkSherry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 277 145 self)
				(= global123 0)
			)
			(1
				(sam setCycle: CT 2 1)
				(gEgo setHeading: 270 self)
			)
			(2
				(= ticks 120)
			)
			(3
				(sherry setCycle: End self)
				(sam setCycle: Beg)
			)
			(4
				(LoadMany rsVIEW 286)
				(= ticks 60)
			)
			(5
				(sherry view: 286 loop: 1 cel: 0 setCycle: End self)
				(sam setCycle: CT 2 1)
			)
			(6
				(= ticks 30)
			)
			(7
				(LoadMany rsVIEW 287)
				(sherry setCycle: CT 9 -1 self)
			)
			(8
				(sherry
					view: 287
					loop: 0
					cel: 0
					posn: 175 129
					cycleSpeed: 3
					setCycle: End
				)
				(sam setSpeed: 2 setCycle: CT 8 1 self)
			)
			(9
				(Load rsVIEW 283)
				(sam setCycle: End self)
			)
			(10
				(sam view: 283 loop: 1 cel: 0 setCycle: End self)
			)
			(11
				(LoadMany rsVIEW 2750 276)
				(sam
					view: 2750
					heading: 45
					loop: 6
					setLooper: Grooper
					setCycle: StopWalk 276
					setHeading: 90 self
				)
			)
			(12
				(sam
					setLoop: 0 1
					heading: 90
					setCycle: Rev
					setMotion: MoveTo 139 140 self
				)
			)
			(13
				(LoadMany rsVIEW 276)
				(sam
					setLoop: -1
					setLooper: Grooper
					heading: 90
					setCycle: StopWalk 276
					cycleSpeed: 6
					setHeading: 180 self
				)
			)
			(14
				(sherry cycleSpeed: 6 setCycle: Beg self)
			)
			(15
				(LoadMany rsVIEW 288)
				(sherry
					view: 288
					loop: 0
					cel: 0
					posn: 178 141
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(16
				(sherry
					setLoop: 1 1
					cel: 0
					setCycle: End self
					setMotion: MoveTo 173 148 self
				)
			)
			(17 0)
			(18
				(sherry setLoop: -1 loop: 2 cel: 0 setCycle: End self)
			)
			(19
				(LoadMany rsVIEW 2900 289)
				(sherry
					view: 2900
					loop: 4
					heading: 135
					posn: 176 145
					setLooper: Grooper
					origStep: 771
					setScaler: Scaler 100 74 145 95
					setCycle: StopWalk 289
				)
				(FrameOut (gCast elements:) 1)
				(gCurRoom setScript: sherryLeave)
				(self dispose:)
			)
		)
	)
)

(instance sherryLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 2 29 1 self) ; "Ah, um... yes, well hello, John! I was just checking Sherry. It appears she might have a bit of a chest cold."
			)
			(1
				(sam setHeading: 90)
				(sherry setMotion: PolyPath 310 122 self)
			)
			(2
				(sherry setPri: -1 setMotion: DPath 310 115 278 115 self)
			)
			(3
				(sam approachX: 212 approachY: 139 fixPriority: 1 priority: 139)
				(sherry dispose:)
				(gMessager sayRange: 2 2 27 1 2 self) ; "On to the business at hand, John. Two bodies were brought in this afternoon. They fit your killer's MO. Both have burn wounds on the face and upper torso, and ruptured gastrointestinal linings."
			)
			(4
				(gGame handsOn:)
				(= global123 2)
				(sam setScript: samBodies)
				(self dispose:)
			)
		)
	)
)

(instance samBodies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 90)
			)
			(1
				(= seconds 15)
			)
			(2
				(gMessager say: 2 2 27 3 self) ; "Say, John, did you hear me? I said two additional bodies were brought in this afternoon. They fit your killer's MO."
			)
			(3
				(= seconds 10)
			)
			(4
				(sam setScript: samGoesOff)
				(self dispose:)
			)
		)
	)
)

(instance samGoesOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(Face sam gEgo self)
			)
			(2
				(gMessager sayRandom: 2 2 28 self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance giveBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setSpeed: 6
					setMotion: PolyPath (+ (sam x:) 65) 139 self
				)
			)
			(1
				(sam setHeading: 90)
				(gEgo setHeading: 270 self)
			)
			(2
				(= ticks 30)
			)
			(3
				((sam looper:) dispose:)
				(sam looper: 0)
				(= local3 (mySyncedView new:))
				(gEgo
					put: 23 275 ; boneBaggie
					view: 9032
					loop: 0
					cel: 0
					setCycle: End self
				)
				(local3 offset: 59276 init: gEgo)
			)
			(4
				(sam
					view: 278
					loop: 0
					cel: 0
					x: (- (sam x:) 5)
					setCycle: End self
				)
			)
			(5
				(local3 dispose:)
				(sam loop: 1 cel: 0)
				(gEgo setCycle: Beg self)
			)
			(6
				(gMessager sayRange: 2 2 44 1 5 self) ; "Sam, I unearthed this bone from the Jane Doe 1201-K crime scene. Strangest thing, a stray dog was there guarding it."
			)
			(7
				(sam setCycle: End self)
			)
			(8
				(gEgo
					view: 0
					loop: 1
					y: 139
					setScaler: Scaler 141 53 189 69
					normalize: 0
					setMotion: MoveTo 196 145 self
				)
			)
			(9
				(gEgo setHeading: 315 self)
			)
			(10
				(= ticks 60)
			)
			(11
				(gMessager say: 2 2 44 6 self) ; "Trust me, John, I will place the tests on the top of my priority list."
			)
			(12
				(gPqFlags set: 165)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sam of Actor
	(properties
		noun 2
		approachX 213
		approachY 143
		x 164
		y 142
		view 276
		signal 20481
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(Face gEgo sam)
				(super doVerb: theVerb)
			)
			(52 ; notebook
				(cond
					(
						(or
							(and (== gDay 2) (gPqFlags test: 173))
							(and (== gDay 3) (gPqFlags test: 174))
							(and (== gDay 4) (gPqFlags test: 175))
							(and (== gDay 5) (gPqFlags test: 176))
						)
						(gMessager say: noun theVerb 66 0) ; "You've already notated the information from Sam."
					)
					(local5
						(switch gDay
							(2
								(gPqFlags set: 173)
							)
							(3
								(gPqFlags set: 174)
							)
							(4
								(gPqFlags set: 175)
							)
							(5
								(gPqFlags set: 176)
							)
						)
						(gCurRoom setScript: scribbleSam)
					)
					(else
						(gMessager say: noun theVerb 65) ; "What has Sam told you worth notating?"
					)
				)
			)
			(34 ; boneBaggie
				(self setScript: 0)
				(gGame points: 4)
				(gCurRoom setScript: giveBone)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance samTeller of Teller
	(properties
		sayNoun 3
		verb 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(switch gDay
				(2
					(cond
						((not local1)
							(++ local1)
							(sam setScript: day2Greet)
						)
						((== local1 1)
							(++ local1)
							(gMessager say: 2 2 3 0) ; "I'd like to ask you a few questions, Sam. You got a minute?"
						)
						(else
							(= local5 1)
							(super doVerb: theVerb)
						)
					)
				)
				(3
					(cond
						((gPqFlags test: 11)
							(= local5 1)
							(super doVerb: theVerb)
						)
						((and (== theVerb 2) (not local1)) ; Talk
							(++ local1)
							(sam setScript: day3Greet)
						)
						(else
							(= local5 1)
							(super doVerb: theVerb)
						)
					)
				)
				(4
					(cond
						((== global123 2)
							(sam setScript: 0)
							(= global123 3)
							(gPqFlags set: 165)
							(= local5 1)
							(super doVerb: theVerb)
						)
						((== global123 3)
							(gPqFlags set: 165)
							(= local5 1)
							(super doVerb: theVerb)
						)
						((and (== theVerb 2) (not local1)) ; Talk
							(++ local1)
							(sam setScript: day4Greet)
						)
						((== (sam script:) day4Greet)
							(sam script: 0)
							(= local5 1)
							(super doVerb: theVerb)
						)
						(else
							(= local5 1)
							(super doVerb: theVerb)
						)
					)
				)
				(else
					(= local5 1)
					(super doVerb: theVerb)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(2
				(gPqFlags set: 18)
			)
			(25
				(= local2 1)
			)
			(26
				(gPqFlags set: 141)
			)
			(23
				(gPqFlags set: 89)
			)
			(52
				(gPqFlags set: 137)
			)
			(51
				(gPqFlags set: 138)
			)
		)
		(if (== gDay 3)
			(gPqFlags set: 136)
		)
		(gPqFlags set: 11)
		(super sayMessage:)
	)

	(method (showCases)
		(super
			showCases:
				3
				(== gDay 2)
				1
				(and
					(== gDay 2)
					(or (gPqPointFlags test: 6) (gPqFlags test: 8))
				)
				2
				(and
					(== gDay 4)
					(not (gEgo has: 23)) ; boneBaggie
					(!= ((gInventory at: 23) owner:) 275) ; boneBaggie
				)
				11
				(and
					(== gDay 4)
					(not (gEgo has: 23)) ; boneBaggie
					(!= ((gInventory at: 23) owner:) 275) ; boneBaggie
				)
				12
				(== gDay 3)
				57
				(and
					(== gDay 4)
					(not (gEgo has: 23)) ; boneBaggie
					(!= ((gInventory at: 23) owner:) 275) ; boneBaggie
				)
				26
				local2
				40
				(and
					(== gDay 4)
					(or (gEgo has: 23) (== ((gInventory at: 23) owner:) 275)) ; boneBaggie, boneBaggie
				)
				39
				(and
					(== gDay 4)
					(or (gEgo has: 23) (== ((gInventory at: 23) owner:) 275)) ; boneBaggie, boneBaggie
				)
				58
				(and
					(== gDay 4)
					(or (gEgo has: 23) (== ((gInventory at: 23) owner:) 275)) ; boneBaggie, boneBaggie
				)
				56
				(and
					(== gDay 4)
					(or (gEgo has: 23) (== ((gInventory at: 23) owner:) 275)) ; boneBaggie, boneBaggie
				)
				59
				(== gDay 5)
				63
				(== gDay 5)
				44
				(== gDay 5)
		)
	)
)

(instance sherry of Actor
	(properties
		x 169
		y 128
		priority 9
		fixPriority 1
		view 286
		signal 16385
	)
)

(instance scribbleHick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setSpeed: 6 setHeading: 0 self)
			)
			(1
				(Load rsVIEW 9018)
				((= register (Actor new:))
					name: {egoLegs}
					view: 9018
					loop: 1
					cel: 0
					x: (hickman approachX:)
					y: (hickman approachY:)
					setScaler: Scaler 141 53 189 69
					init:
				)
				(gEgo
					view: 9018
					loop: 0
					cel: 0
					y: (+ (hickman approachY:) 1)
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: ROsc 6 12 14 self)
			)
			(3
				(gMessager say: 12 52 0 0 self) ; "You notate the state of affairs."
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(= cycles 1)
			)
			(6
				(gEgo
					heading: 0
					x: (hickman approachX:)
					y: (hickman approachY:)
					normalize: 0 3
				)
				(register dispose:)
				(= register 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance scribbleSam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setSpeed: 6)
				(switch gDay
					(2
						(gEgo setHeading: 0 self)
					)
					(3
						(gEgo setHeading: 45 self)
					)
					(4
						(cond
							((gEgo has: 23) ; boneBaggie
								(gEgo setHeading: 270 self)
							)
							((== (sam y:) 126)
								(gEgo setHeading: 45 self)
							)
							(else
								(gEgo setHeading: 270 self)
							)
						)
					)
					(5
						(if (== gPrevRoomNum 240)
							(gEgo setHeading: 270 self)
						else
							(gEgo setHeading: 45 self)
						)
					)
				)
			)
			(1
				(switch gDay
					(2
						(gEgo view: 5 loop: 3 cel: 0)
					)
					(3
						(gEgo view: 5 loop: 6 cel: 0)
					)
					(4
						(cond
							((gEgo has: 23) ; boneBaggie
								(gEgo view: 5 loop: 1 cel: 0)
							)
							((== (sam y:) 126)
								(gEgo view: 5 loop: 6 cel: 0)
							)
							(else
								(gEgo view: 5 loop: 1 cel: 0)
							)
						)
					)
					(5
						(if (== gPrevRoomNum 240)
							(gEgo view: 5 loop: 1 cel: 0)
						else
							(gEgo view: 5 loop: 6 cel: 0)
						)
					)
				)
				(UpdateScreenItem gEgo)
				(= cycles 1)
			)
			(2
				((ScriptID 39 0) init: self) ; NotebookOut
			)
			(3
				(gMessager say: 2 52 0 0 self) ; "Sam Nobles is a walking encyclopedia of information."
			)
			(4
				((ScriptID 39 1) init: self) ; NotebookIn
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hickman of View
	(properties
		noun 12
		approachX 146
		approachY 143
		x 172
		y 129
		z 8
		priority 136
		fixPriority 1
		view 1275
		signal 20480
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; notebook
			(gCurRoom setScript: scribbleHick)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance musicThing of Prop
	(properties
		view 18
		signal 16392
	)

	(method (init)
		(super init: &rest)
		(gGlobalSound0 fade: 1 300 10 0 self)
	)

	(method (cue)
		(if
			(or
				(OneOf gDay 2 3)
				(and
					(== gDay 4)
					(not (gEgo has: 23)) ; boneBaggie
					(!= ((gInventory at: 23) owner:) 275) ; boneBaggie
				)
				(and (== gDay 5) (not (gCast contains: sherry)))
			)
			(self setScript: sawSound)
		)
		(gGlobalSound0 number: 270 loop: -1 play:)
	)
)

(instance sawSound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 600 750))
			)
			(1
				(gGlobalSound2 number: 982 loop: -1 signal: 5 play:)
				(= ticks (Random 240 480))
			)
			(2
				(gGlobalSound2 number: 0 stop:)
				(if (== register 3)
					(self dispose:)
				else
					(++ register)
					(self changeState: 0)
				)
			)
		)
	)
)

(instance shelves of Feature
	(properties
		noun 4
		nsLeft 245
		nsTop 62
		nsRight 287
		nsBottom 117
		approachX 265
		approachY 125
		approachDist 53
		x 266
		y 89
	)
)

(instance counter of Feature
	(properties
		noun 5
		nsLeft 131
		nsTop 68
		nsRight 243
		nsBottom 81
		approachX 213
		approachY 119
		approachDist 78
		x 187
		y 74
	)
)

(instance sink of Feature
	(properties
		noun 6
		approachX 78
		approachY 150
		approachDist 101
		x 22
		y 115
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 31 100 46 113 45 130 16 139 0 139 0 104
					yourself:
				)
		)
	)
)

(instance exTable of Feature
	(properties
		noun 22
		x 150
		y 83
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 115 85 199 84 213 83 214 88 213 91 199 93 109 94 103 91 102 88
					yourself:
				)
		)
	)
)

(instance door of Feature
	(properties
		noun 7
		nsLeft 289
		nsTop 28
		nsRight 319
		nsBottom 116
		approachX 305
		approachY 117
		x 304
		y 72
	)
)

(instance poster of Feature
	(properties
		noun 24
		nsLeft 246
		nsRight 280
		nsBottom 41
		x 304
		y 72
	)
)

(instance posterLeft of Feature
	(properties
		noun 24
		nsLeft 9
		nsRight 50
		nsBottom 58
		x 25
		y 58
	)
)

(instance largeWindow of Feature
	(properties
		noun 23
		x 50
		y 10
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 114 0 125 2 125 28 60 18 61 0
					yourself:
				)
		)
	)
)

(instance theScale of Feature
	(properties
		noun 21
		x 110
		y 35
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 111 30 116 30 119 35 119 41 115 45 114 51 122 56 122 63 119 71 105 71 103 66 103 56 109 52 108 44 104 39 105 35 107 31
					yourself:
				)
		)
	)
)

(instance knives of Feature
	(properties
		heading 294
		nsLeft 66
		nsTop 87
		nsRight 95
		nsBottom 98
		approachX 94
		approachY 143
		approachDist 50
		x 80
		y 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (musicThing script:)
					((musicThing script:)
						ticks: 0
						seconds: 0
						cycles: 0
						dispose:
					)
					(gGlobalSound2 number: 0 stop:)
				)
				(gCurRoom setInset: knivesInset)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance knivesInset of Inset
	(properties
		picture 280
		style 9
		disposeNotOnMe 1
		noun 31
	)

	(method (init)
		(if (IsHiRes)
			(= picture 10280)
		)
		(gGame fade: 100 0 10)
		(gTheIconBar disable: 3 7 show: 0)
		(super init: &rest)
		(tools init:)
		(faucet init:)
		(intercom init:)
		(lightSwitch init:)
		(tubing init:)
		(FrameOut)
		(gGame fade: 0 100 10)
	)

	(method (onMe param1)
		(return (and (<= 36 (param1 x:) 284) (<= 0 (param1 y:) 148)))
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp0 (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		else
			(temp0 doit: theVerb self)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(gTheIconBar enable: 3 7)
		(super dispose:)
		(FrameOut)
		(gGame fade: 0 100 10)
	)
)

(instance tools of Feature
	(properties
		noun 8
		y 100
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 52 95 53 85 56 82 61 80 53 73 53 71 57 71 65 73 71 78 73 76 66 71 71 68 80 68 91 73 101 71 101 68 104 70 115 67 118 65 126 64 129 64 199 50 209 53 213 55 265 71 273 71 276 73 280 73 284 77 284 115 275 117 268 123 252 130 233 138 230 137 223 142 212 147 130 147 127 140 110 132 93 130 91 110 64 89 55 96
					yourself:
				)
		)
	)
)

(instance faucet of Feature
	(properties
		noun 30
		y 56
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 243 22 254 18 268 18 272 20 273 28 277 26 277 28 272 34 269 53 264 56 253 60 245 60 241 37 242 25
					yourself:
				)
		)
	)
)

(instance intercom of Feature
	(properties
		noun 28
		y 24
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 186 0 182 25 152 27 142 21 143 0
					yourself:
				)
		)
	)
)

(instance lightSwitch of Feature
	(properties
		noun 27
		y 33
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 125 0 126 34 90 38 86 1 92 0
					yourself:
				)
		)
	)
)

(instance tubing of Feature
	(properties
		noun 29
		y 69
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 49 0 51 37 55 51 61 57 72 58 81 53 89 43 90 39 92 39 91 45 81 57 72 61 59 59 50 49 45 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 57 0 57 3 60 20 64 71 60 72 55 16 51 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 244 0 240 24 240 41 242 47 244 65 239 63 236 43 232 61 227 59 231 45 235 23 239 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 258 129 263 126 264 147 260 147
					yourself:
				)
		)
	)
)

(instance samTalker of Narrator
	(properties
		x 30
		y 5
	)
)

(instance sherryTalker of Narrator
	(properties
		x 100
		y 5
	)
)

(instance egoTalker of Narrator
	(properties
		x 158
		y 2
		talkWidth 158
	)
)

(instance mySyncedView of SyncedView
	(properties)

	(method (init param1 &tmp [temp0 2])
		(= client param1)
		(= cel (client cel:))
		(= loop (client loop:))
		(= view (+ (client view:) offset))
		(= signal (client signal:))
		(|= signal $4000)
		(= scaleSignal 1)
		(= scaleX (client scaleX:))
		(= scaleY (client scaleY:))
		(self fixPriority: 1)
		(= priority (+ (client priority:) 1))
		(= x (client x:))
		(= y (+ (client y:) 1))
		(= z (+ (client z:) 1))
		(if (not (gCast contains: self))
			(= lsRight (= lsBottom (= lsLeft (= lsTop 0))))
		)
		(BaseSetter self)
		(gCast addToEnd: self)
		(|= -info- $0010)
		(self initialize:)
		(= plane (gCast plane:))
		(AddScreenItem self)
	)

	(method (doit &tmp temp0)
		(= cel (client cel:))
		(= loop (client loop:))
		(= view (+ (client view:) offset))
		(= signal (client signal:))
		(|= signal $4000)
		(= scaleX (client scaleX:))
		(= scaleY (client scaleY:))
		(self fixPriority: 1)
		(= priority (+ (client priority:) 1))
		(= x (client x:))
		(= y (+ (client y:) 1))
		(= z (+ (client z:) 1))
		(UpdateScreenItem self)
	)
)

(instance dftDoVerb of Code
	(properties)

	(method (doit)
		(return 1)
	)
)

(instance hiResSkel1 of View
	(properties
		x 32
		y 65
		view 2755
	)
)

(instance hiResSkel2 of View
	(properties
		x 264
		y 54
		view 2755
		loop 1
		cel 2
	)
)

(instance hiResSink of View
	(properties
		y 68
		view 2755
		loop 2
	)
)

