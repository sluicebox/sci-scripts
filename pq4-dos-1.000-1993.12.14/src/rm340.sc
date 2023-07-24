;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Inset)
(use Talker)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm340 0
	paulTalker 1
)

(local
	local0
	local1
	local2
)

(instance careyTalker of Narrator
	(properties
		x 50
		y 100
	)
)

(instance paulTalker of Narrator
	(properties
		x 120
		y 1
		talkWidth 143
	)
)

(instance rm340 of Room
	(properties
		noun 6
		picture 340
	)

	(method (init)
		(proc0_4 1)
		(super init: &rest)
		(gGame handsOff:)
		(counter init:)
		(cashRegister init:)
		(magazine init:)
		(exitRoom init:)
		(logo init:)
		(leftPic init:)
		(rightPic init:)
		(counterStick init:)
		(paul init: signal: (| (paul signal:) $5000))
		(head init: signal: (| (head signal:) $5000))
		(if (and (gPqFlags test: 116) (not (gEgo has: 6))) ; stick
			(self setScript: inAgainScr)
		else
			(gGame handsOn:)
			(self setScript: greetScr)
		)
		(if (and (== gDay 5) (gEgo has: 25)) ; tape
			(paulTeller init: paul 340)
			(head actions: paulTeller)
		)
		(gEgo setTalker: careyTalker)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance greetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (gPqFlags test: 122)
					(gPqFlags clear: 122)
					(gMessager say: 0 0 29 0 self) ; "I'm with Major Crimes, Homicide."
				else
					(= cycles 1)
				)
			)
			(2
				(head setCycle: End self)
			)
			(3
				(gMessager say: 5 2 6 0 self) ; "How's it going, dude?"
			)
			(4
				(= seconds 10)
			)
			(5
				(self start: 3 init:)
			)
		)
	)
)

(instance inAgainScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (gPqFlags test: 122)
					(gPqFlags clear: 122)
					(gMessager say: 0 0 29 0 self) ; "I'm with Major Crimes, Homicide."
				else
					(= cycles 1)
				)
			)
			(2
				(head setCycle: End self)
			)
			(3
				(gMessager say: 5 2 25 0 self) ; "Hey, dude, ready to finish our transaction and make a selection?"
			)
			(4
				(= local2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance head of Prop
	(properties
		x 174
		y 74
		priority 11
		fixPriority 1
		view 3401
		loop 1
	)

	(method (dispose)
		(= actions 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(paul doVerb: theVerb)
	)
)

(instance paul of Prop
	(properties
		noun 5
		x 177
		y 153
		priority 10
		fixPriority 1
		view 3401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((== gDay 4)
						(cond
							((== (head actions:) paulTeller)
								(return)
							)
							((not (gPqFlags test: 154))
								(gMessager say: noun theVerb 31 0) ; "Hello. I'm Detective Carey, LAPD. I was wondering if I could ask you some questions."
								(paulTeller init: paul 340)
								(head actions: paulTeller)
							)
							(else
								(gMessager say: noun theVerb 36 0) ; "Hello. I'm back to ask you a few more questions."
								(paulTeller init: paul 340)
								(head actions: paulTeller)
							)
						)
					)
					((and (== gDay 5) (gEgo has: 25)) ; tape
						(if (== (head actions:) paulTeller)
							(return)
						else
							(gMessager say: noun theVerb 38 0) ; "Well, I'm back."
						)
					)
					(local2
						(switch (++ local0)
							(1
								(gMessager say: noun theVerb 26 0) ; "What about the exchange? What can I exchange for?"
							)
							(else
								(gMessager say: noun theVerb 27 0) ; "What exactly can I exchange for?"
							)
						)
					)
					((and (gPqFlags test: 117) (not (gEgo has: 6))) ; stick
						(gMessager say: noun theVerb 24 0) ; "I was wondering if I can have the tape back?"
					)
					((gPqFlags test: 116)
						(gMessager say: noun theVerb 19) ; "What about the tape?"
					)
					((gEgo has: 6) ; stick
						(switch (++ local0)
							(1
								(gMessager say: noun theVerb 20 0) ; "So this stick is really authentic?"
							)
							(2
								(gMessager say: noun theVerb 21 0) ; "Well, thanks."
							)
							(else
								(gMessager say: noun theVerb 22 0) ; "Before you start up, dude, I have to tell you, I'm runnin' a business here. I don't have all day to jaw."
							)
						)
					)
					(else
						(switch (++ local0)
							(1
								(gMessager say: noun theVerb 2 0) ; "I thought I'd stop by and see if you remembered anything about the abandoned car we talked about."
							)
							(2
								(gMessager say: noun theVerb 14 0) ; "I was wondering if you could recall seeing anybody new, or any suspicious characters, hanging around the neighborhood in the last week or so."
							)
							(3
								(gMessager say: noun theVerb 15 0) ; "People tend to talk among themselves, rather than talking to the police. What can you tell me about the talk on the street?"
							)
							(4
								(gPqFlags set: 97)
								(gMessager say: noun theVerb 16 0) ; "Well, has anyone actually seen this woman? Or for that matter, are there any new women on the street?"
							)
							(else
								(gMessager say: noun theVerb 17 0) ; "Well, thank you for your time. I appreciate the information."
							)
						)
					)
				)
			)
			(36 ; tape
				(gGame handsOff:)
				(gGame points: 2)
				(gCurRoom setScript: tapeScr)
			)
			(4 ; Do
				(if local2
					(gMessager say: noun theVerb 28 0) ; "I'm not into that... you should find yourself a woman."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance paulTeller of Teller
	(properties
		sayNoun 7
		verb 5
	)

	(method (showCases)
		(super
			showCases:
				7
				(and (== gDay 4) (gPqFlags test: 165))
				8
				(and (== gDay 4) (gPqFlags test: 165))
				9
				(and (== gDay 4) (gPqFlags test: 165))
				10
				(and (== gDay 4) (not (gPqFlags test: 165)))
				11
				(and (== gDay 4) (not (gPqFlags test: 165)))
				12
				(== gDay 5)
				13
				(== gDay 5)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(gCurRoom setScript: 0)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance tapeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager sayRange: 5 36 18 1 2 self) ; "This Yo Money tape was found on the desk of Luella Parker, a victim in a homicide case I'm investigating. Your store's receipt was taped to the cassette."
			)
			(1
				(LoadMany rsVIEW 347 348)
				(gEgo put: 25 340) ; tape
				(gPqFlags set: 116)
				(paulTeller client: 0 dispose:)
				(paul actions: 0)
				(head hide: actions: 0)
				(paul view: 347 loop: 0 cel: 0 actions: 0)
				(= cycles 1)
			)
			(2
				(= ticks 60)
			)
			(3
				(paul setCycle: End self)
			)
			(4
				(paul view: 348 cel: 0 setCycle: End self)
			)
			(5
				(Load rsVIEW 3401)
				(= ticks 60)
			)
			(6
				(head show:)
				(paul view: 3401 loop: 0 cel: 0)
				(= cycles 2)
			)
			(7
				(gMessager say: 5 36 18 3 self) ; "Take a look, dude. See what you'd like."
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stickScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(LoadMany rsVIEW 344 345 346)
				(head hide:)
				(= register
					((View new:) view: 344 posn: 177 153 ignoreActors: init:)
				)
				(paul view: 344 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(= cycles 1)
			)
			(3
				(register dispose:)
				(paul view: 345 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(paul view: 346 loop: 0 cel: 0 setCycle: End self)
			)
			(5
				(Load rsVIEW 3401)
				(stick
					x: (- (paul x:) 35)
					y: (+ (paul y:) 6)
					z: 20
					setPri: (+ (paul priority:) 1)
					init:
				)
				(= ticks 60)
			)
			(6
				(head show:)
				(paul view: 3401 loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance noDealScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 5 2 23 0 self) ; "There ain't no cash back, dude. Store policy. You can choose out of the counter now, or come back later. But that's the deal."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance counterStick of View
	(properties
		x 177
		y 153
		view 3401
		loop 2
	)

	(method (doVerb theVerb)
		(counter doVerb: theVerb)
	)
)

(instance stick of Prop
	(properties
		noun 11
		view 349
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 2)
				(gEgo get: 6) ; stick
				(= local0 0)
				(gPqFlags clear: 116)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance counterInset of Inset
	(properties
		picture 345
		disposeNotOnMe 1
		noun 4
	)

	(method (init)
		(gGame fade: 100 0 10)
		(gTheIconBar disable: 3 7 6 show: 0)
		(super init: &rest)
		(stick1 init:)
		(stick2 init:)
		(stick3 init:)
		(stick4 init:)
		(theCd init:)
		(self setScript: insetScript)
		(FrameOut)
		(gGame fade: 0 100 10)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 48 (param1 x:) 268) (<= 0 (param1 y:) 147)))
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(gTheIconBar enable: 0 3 7)
		(super dispose:)
		(gGame handsOff:)
		(if local1
			(gCurRoom setScript: stickScr)
		else
			(gPqFlags set: 117)
			(gCurRoom setScript: noDealScr)
		)
		(FrameOut)
		(gGame fade: 0 100 10)
	)
)

(instance stick1 of Feature
	(properties
		noun 12
		y 200
	)

	(method (init)
		(self createPoly: 111 59 226 88 225 92 110 63)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local1 1)
				(counterInset dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stick2 of Feature
	(properties
		noun 13
		y 200
	)

	(method (init)
		(self createPoly: 121 72 239 106 239 111 119 77)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local1 1)
				(counterInset dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stick3 of Feature
	(properties
		noun 14
		y 200
	)

	(method (init)
		(self createPoly: 250 113 253 119 129 89 128 85)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local1 1)
				(counterInset dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stick4 of Feature
	(properties
		noun 15
		y 200
	)

	(method (init)
		(self createPoly: 113 84 234 123 234 128 111 89)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local1 1)
				(counterInset dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theCd of Feature
	(properties
		noun 16
		y 200
	)

	(method (init)
		(self createPoly: 85 32 101 38 108 67 70 107 53 76)
		(super init: &rest)
	)
)

(instance insetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 4 1 0 0) ; "Eight-track tapes, drumsticks... drumsticks?"
				(= seconds 10)
			)
			(2
				(gMessager say: 5 0 30 0 self) ; "Can I help you with somethin'?"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance counter of Feature
	(properties
		noun 2
		x 161
		y 154
	)

	(method (init)
		(self createPoly: 256 120 272 120 272 148 48 148 48 120)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (gPqFlags test: 116) (not (gCast contains: stick)))
					(gCurRoom setInset: counterInset)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cashRegister of Feature
	(properties
		noun 1
		x 63
		y 155
	)

	(method (init)
		(self
			createPoly: 48 86 88 86 91 97 98 100 98 105 107 108 108 128 87 134 48 134
		)
		(super init: &rest)
	)
)

(instance magazine of Feature
	(properties
		noun 3
		x 220
		y 155
	)

	(method (init)
		(self
			createPoly: 180 123 194 119 199 119 211 113 251 121 253 122 253 128 241 132 220 136
		)
		(super init: &rest)
	)
)

(instance logo of Feature
	(properties
		noun 8
		x 130
		y 16
	)

	(method (init)
		(self createPoly: 152 10 147 15 132 21 115 22 106 18 94 20 96 10)
		(super init: &rest)
	)
)

(instance leftPic of Feature
	(properties
		noun 9
		x 86
		y 67
	)

	(method (init)
		(self createPoly: 59 24 119 23 119 71 59 70)
		(super init: &rest)
	)
)

(instance rightPic of Feature
	(properties
		noun 9
		x 213
		y 46
	)

	(method (init)
		(self createPoly: 194 10 232 10 232 49 193 49)
		(super init: &rest)
	)
)

(instance exitRoom of Feature
	(properties
		x 150
		y 170
	)

	(method (doVerb)
		(gCurRoom newRoom: 335)
	)

	(method (init)
		(self createPoly: 0 0 44 0 44 148 272 148 272 0 319 0 319 149 0 149)
		(super init: &rest)
	)
)

