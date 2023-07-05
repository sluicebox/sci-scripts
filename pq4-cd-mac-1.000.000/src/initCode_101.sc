;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use TransPlane)
(use n045)
(use Str)
(use Print)
(use Inset)
(use Scaler)
(use PolyPath)
(use Feature)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	initCode 0
	body 1
	washInset 2
	helper 3
	bodyInset 4
	body 5
	rmSFX 6
	tape 7
	cop1 8
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
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	[local17 2]
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
)

(procedure (localproc_0)
	(if (and (!= (crim loop:) 1) (!= (crim loop:) 4))
		(crim heading: 270 loop: 1)
	)
	(crim
		view: 1020
		setLoop: -1
		setMotion: 0
		setLooper: Grooper
		setCycle: StopWalk 1023
		z: 0
		illegalBits: 0
		setSpeed: global112
	)
)

(instance initCode of Code
	(properties)

	(method (doit)
		(gPqFlags set: 27)
		(if (gPqFlags test: 133)
			(gGlobalSound0 number: 100 loop: -1 play:)
		else
			(rmMusic number: 101 loop: -1 flags: 1 play:)
		)
		(Load rsVIEW 1002)
		(Load rsVIEW 1004)
		(cop2Legs init: signal: (| (cop2Legs signal:) $5000))
		(cop2 init: signal: (| (cop2 signal:) $5000))
		(crim
			setScaler: Scaler 94 24 143 89
			init:
			signal: (| (crim signal:) $5000)
		)
		(coroner setScaler: Scaler 81 17 140 89)
		(if (gPqFlags test: 133)
			(coroner view: 107 loop: 1 x: 232 y: 134)
		else
			(woman init: signal: (| (woman signal:) $4800))
		)
		(coroner init: signal: (| (coroner signal:) $4000))
		(cop1 init: signal: (| (cop1 signal:) $5800))
		(spiff init: signal: (| (spiff signal:) $5000))
		(jack init: signal: (| (jack signal:) $5800))
		(body init: signal: (| (body signal:) $5000))
		(tape init: signal: (| (tape signal:) $5000))
		(signLight init: signal: (| (signLight signal:) $4000))
		(garageLight init: signal: (| (garageLight signal:) $4000))
		(billboardLight init: signal: (| (billboardLight signal:) $4000))
		(clueScr init:)
		(if (gPqFlags test: 133)
			(spiff setScript: spiffScript)
			(jack setScript: jackScript)
			(gGame handsOn:)
		else
			(gCurRoom setScript: womanScript)
		)
	)
)

(instance clueScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(super dispose: &rest)
		(gTheDoits delete: self)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 900)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (gCurRoom script:)
					(-- state)
					(= cycles 2)
				else
					(= ticks 30)
				)
			)
			(3
				(cond
					((and (gPqPointFlags test: 1) local7 local6 (gPqPointFlags test: 0))
						(self dispose:)
					)
					((and (not local19) (not (gPqPointFlags test: 1)))
						(= local19 1)
						(gMessager say: 33 2 46 0 self) ; "John, please notate what you feel is important about the body. I'd like to get it moved to the morgue and begin autopsy."
					)
					((and (not local20) (not local7))
						(= local20 1)
						(gMessager say: 31 2 47 0 self) ; "Carey, if you would chalk the body we could move on with the investigation. No disrespect intended."
					)
					((and (not local21) (not local6))
						(= local21 1)
						(gMessager say: 32 2 44 0 self) ; "Detective Carey, I realize you know your business. However, the longer you delay in locating possible evidence the colder the evidence trail."
					)
					((and (not local22) (not (gPqPointFlags test: 0)))
						(= local22 1)
						(gMessager say: 24 2 45 0 self) ; "Excuse me, Sir. With all due respect, I would like to point out the wall graffiti. From my daily patrols I have come to recognize that symbol as a local gang symbol. It might be important. It might be worth notating."
					)
					(else
						(if (and (not local19) (gPqPointFlags test: 1))
							(= local19 1)
						)
						(if (and (not local20) local7)
							(= local20 1)
						)
						(if (and (not local21) local6)
							(= local21 1)
						)
						(if (and (not local22) (gPqPointFlags test: 0))
							(= local22 1)
						)
						(if
							(and
								(== local19 1)
								(== local20 1)
								(== local21 1)
								(== local22 1)
							)
							(if (not (gPqPointFlags test: 1))
								(= local19 0)
							)
							(if (not local7)
								(= local20 0)
							)
							(if (not local6)
								(= local21 0)
							)
							(if (not (gPqPointFlags test: 0))
								(= local22 0)
							)
						)
						(= state 1)
						(= cycles 2)
					)
				)
			)
			(4
				(= state 1)
				(= seconds 180)
			)
		)
	)
)

(instance cop2 of Prop
	(properties
		noun 24
		approachX 107
		approachY 147
		approachDist 20
		x 54
		y 141
		view 1005
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gCurRoom setScript: toCop2Script)
			)
			(27 ; badge
				(if local25
					(gMessager say: 0 27 32 0) ; "Identifying yourself again is unnecessary."
				else
					(= local25 1)
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toCop2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= (gEgo x:) 107) (!= (gEgo y:) 147))
					(if (< (gEgo y:) 138)
						(self setScript: (ScriptID 100 4) self) ; underTapeScript
					else
						(= cycles 2)
					)
				else
					(= state 3)
					(= cycles 2)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo
					setMotion: PolyPath (cop2 approachX:) (cop2 approachY:) self
				)
			)
			(2
				(gEgo setHeading: 270 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(cond
					((and (gPqPointFlags test: 6) (not local13))
						(gMessager say: 24 2 38 0 self) ; "Officer, I want you to notify detective headquarters and communications we've discovered another homicide, approximate age, six years, apparent victim of gunshot wounds."
						(= local13 1)
					)
					((> local11 1)
						(gMessager say: 24 2 41 0 self) ; "Is there anything else you can tell me, Officer?"
					)
					((== local11 1)
						(gMessager say: 24 2 27 0 self) ; "That's it?"
						(= local11 2)
					)
					((not local11)
						(gMessager say: 24 2 26 0 self) ; "I'll be stepping in as lead investigator, Officer. Can you tell me what the situation was when you got here?"
						(= local11 1)
					)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cop2Legs of Prop
	(properties
		noun 24
		x 55
		y 80
		view 1005
	)

	(method (doVerb theVerb)
		(cop2 doVerb: theVerb)
	)
)

(instance coroner of Actor
	(properties
		noun 33
		approachX 213
		approachY 131
		x 156
		y 134
		view 107
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(== (gEgo x:) (self approachX:))
						(== (gEgo y:) (self approachY:))
						(< 68 (gEgo heading:) 113)
					)
					(gCurRoom setScript: hugScript)
				else
					(gMessager say: 33 4 34 0) ; "Yes, John, what is it? Can I give you a hand?"
				)
			)
			(2 ; Talk
				(gCurRoom setScript: toCoronerScript)
			)
			(22 ; handgun
				(if local14
					(gMessager say: 33 22 0 0) ; "John, there's been enough violence for one night, don't you think?"
					(= local14 1)
				else
					(gMessager say: 33 22 32 0) ; "Holster your weapon. The situation is charged enough."
				)
			)
			(27 ; badge
				(if local26
					(gMessager say: 0 27 32 0) ; "Identifying yourself again is unnecessary."
				else
					(= local26 1)
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toCoronerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (gEgo y:) 138)
					(self setScript: (ScriptID 100 4) self) ; underTapeScript
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(coroner approachX:)
						(coroner approachY:)
						self
				)
			)
			(2
				(gEgo setHeading: 89 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(cond
					((== local9 2)
						(gMessager say: 33 2 42 0 self) ; "He's just a child, Sam. What's happening on our streets?"
						(= local9 3)
					)
					((== local9 1)
						(= local9 2)
						(gMessager say: 33 2 38 0 self) ; "Sam, we're going to need another ambulance. There's a body of a young boy in the dumpster."
					)
					((not local33)
						(= local33 1)
						(gMessager say: 33 2 26 0 self) ; "Sam, do you have a preliminary finding on Hickman's cause of death?"
					)
					(local33
						(gMessager say: 33 2 27 0 self) ; "What else can you tell me, Sam?"
					)
					(else
						(gMessager say: 33 2 27 0 self) ; "What else can you tell me, Sam?"
					)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hugScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(coroner
					view: 108
					loop: 0
					cel: 0
					x: (- (coroner x:) 9)
					y: (+ (coroner y:) 1)
					setCycle: End self
				)
			)
			(1
				(gEgo x: (+ (gEgo x:) 1))
				(= ticks 20)
			)
			(2
				(gMessager say: 33 4 0 0 self) ; "Do you need a hug, John?"
			)
			(3
				(gEgo x: (- (gEgo x:) 1))
				(= ticks 60)
			)
			(4
				(coroner view: 108 cel: (coroner lastCel:) setCycle: Beg self)
			)
			(5
				(coroner
					view: 107
					setLoop: 1 1
					x: (+ (coroner x:) 9)
					y: (- (coroner y:) 1)
				)
				(= cycles 2)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance spiffLegs of Prop
	(properties
		noun 23
		priority 170
		fixPriority 1
	)

	(method (doVerb theVerb)
		(spiff doVerb: theVerb &rest)
	)
)

(instance woman of Actor
	(properties
		noun 22
		x 108
		y 148
		view 100
		loop 1
	)
)

(instance spiff of Actor
	(properties
		noun 23
		approachX 189
		approachY 152
		x 303
		y 170
		view 1000
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gCurRoom setScript: doSpiffScript 0 2)
			)
			(52 ; notebook
				(if (not (gPqPointFlags test: 28))
					(gCurRoom setScript: doSpiffScript 0 0)
				else
					(gMessager say: 0 52 32 0) ; "This information is already recorded."
				)
			)
			(27 ; badge
				(if local30
					(gMessager say: 0 27 32 0) ; "Identifying yourself again is unnecessary."
				else
					(= local30 1)
					(gCurRoom setScript: doSpiffScript 0 1)
				)
			)
			(47 ; handcuffs
				(gCurRoom setScript: doSpiffScript 0 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doSpiffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: doJackScript self register)
			)
			(1
				((ScriptID 100 8) x: 5) ; careyTalker
				(switch register
					(0
						(gGame points: 2 28)
						(gPqPointFlags set: 28)
						((ScriptID 39 0) init: self) ; NotebookOut
					)
					(4
						(gMessager say: 23 47 0 0 self) ; "S'up? I jest be chillin' here, no law against dat!"
					)
					(1
						(gGame points: 2 105)
						((ScriptID 38 0) init: self) ; BadgeOut
					)
					(2
						(cond
							((== local0 2)
								(gMessager say: 23 2 41 0 self) ; "So Mr. Jones, what you're telling me is, you don't have anything to tell me. Is that correct?"
							)
							((== local0 1)
								(= local0 2)
								(gMessager say: 23 2 27 0 self) ; "Well, Raymond, if this is your neighborhood, then you must know what goes on around here. What happened here tonight? You see anything unusual? Maybe a different car, or some folks from another neighborhood?"
							)
							(else
								(= local0 1)
								(gMessager say: 23 2 26 0 self) ; "I'm Detective Carey, Major Crimes, Homicide, LAPD. I'd like to ask you a question or two."
							)
						)
					)
				)
			)
			(2
				(switch register
					(0
						(gMessager say: 23 52 0 0 self) ; "The young man's interest appears a bit suspicious. Always record your gut feelings. Sometimes, this job is pure instincts."
					)
					(1
						(gMessager say: 23 27 0 0 self) ; "Hello, I'm Detective Carey with the LAPD. Would you mind answering a few questions?"
					)
					(else
						(= cycles 2)
					)
				)
			)
			(3
				(switch register
					(0
						((ScriptID 39 1) init: self) ; NotebookIn
					)
					(1
						((ScriptID 38 1) init: self) ; BadgeIn
					)
					(else
						(= cycles 2)
					)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance jack of Actor
	(properties
		noun 21
		approachX 189
		approachY 152
		x 243
		y 153
		view 103
	)

	(method (doVerb theVerb)
		(if local3
			(gMessager say: 21 0 33 0) ; "Apparently this citizen has seen enough violence for one day."
		else
			(switch theVerb
				(27 ; badge
					(if local29
						(gMessager say: 0 27 32 0) ; "Identifying yourself again is unnecessary."
					else
						(= local29 1)
						(= local2 1)
						(gCurRoom setScript: doJackScript 0 1)
					)
				)
				(52 ; notebook
					(if (not (gPqPointFlags test: 23))
						(= local2 1)
						(gCurRoom setScript: doJackScript 0 0)
					else
						(gMessager say: 0 52 32 0) ; "This information is already recorded."
					)
				)
				(2 ; Talk
					(= local2 1)
					(gCurRoom setScript: doJackScript 0 2)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance doJackScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< (gEgo y:) 138)
					(self setScript: (ScriptID 100 4) self) ; underTapeScript
				else
					(= cycles 2)
				)
			)
			(1
				(gGame handsOff:)
				((ScriptID 100 8) x: 10) ; careyTalker
				(if
					(or
						(!= (gEgo x:) (jack approachX:))
						(!= (gEgo y:) (jack approachY:))
					)
					(gEgo
						setMotion:
							PolyPath
							(jack approachX:)
							(jack approachY:)
							self
					)
				else
					(= cycles 2)
				)
			)
			(2
				(gEgo heading: 90 normalize: 0)
				(= cycles 2)
			)
			(3
				(if (== client doSpiffScript)
					(self dispose:)
				else
					(= cycles 2)
				)
			)
			(4
				(switch register
					(0
						((ScriptID 39 0) init: self) ; NotebookOut
					)
					(1
						(gGame points: 2 106)
						((ScriptID 38 0) init: self) ; BadgeOut
					)
					(2
						(cond
							((== local1 2)
								(gMessager say: 21 2 41 0 self) ; "Any other information you could give me, sir?"
							)
							((== local1 1)
								(= local1 2)
								(gMessager say: 21 2 27 0 self) ; "What time might you have heard these shots, sir?"
							)
							(else
								(gPqPointFlags set: 25)
								(= local1 1)
								(gMessager say: 21 2 26 0 self) ; "Sir, did you see any unusual activity, or unfamiliar cars in the neighborhood?"
							)
						)
					)
				)
			)
			(5
				(cond
					((== register 0)
						(gGame points: 2 23)
						(gPqPointFlags set: 23)
						(gMessager say: 21 52 0 0 self) ; "What is your name sir?"
					)
					((== register 1)
						(gMessager say: 21 27 0 0 self) ; "Hello, I'm Detective Carey, LAPD. Would you mind answering a question or two?"
					)
					((== register 2)
						(gGame handsOn:)
						(= local2 0)
						(self dispose:)
					)
					(else
						(= ticks 120)
					)
				)
			)
			(6
				(switch register
					(0
						((ScriptID 39 1) init: self) ; NotebookIn
					)
					(1
						((ScriptID 38 1) init: self) ; BadgeIn
					)
				)
			)
			(7
				(gGame handsOn:)
				(= local2 0)
				(self dispose:)
			)
		)
	)
)

(instance holster of Feature
	(properties
		noun 29
		nsLeft 171
		nsTop 103
		nsRight 224
		nsBottom 137
		sightAngle 90
		x 171
		y 103
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 52) ; Look, notebook
			(if (not (gPqPointFlags test: 30))
				(gPqPointFlags set: 30)
			)
			(gMessager say: 29 1 0 0) ; "An empty holster can mean only one thing... Another gun on the street."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance cop1 of Actor
	(properties
		noun 31
		x 208
		y 154
		z 5
		priority 149
		fixPriority 1
		view 1009
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(cond
					((and (gPqPointFlags test: 6) (not local12))
						(gMessager say: 31 2 38 0) ; "Officer Woodbury, when we're finished here, I want the neighborhood canvassed to see if anyone's missing a child, but has not yet reported it."
						(= local12 1)
					)
					((== local10 2)
						(gMessager say: 31 2 41 0) ; "Is there anything else you can tell me, Officer Woodbury?"
					)
					((== local10 1)
						(gMessager say: 31 2 27 0) ; "Were you the first on the scene?"
						(= local10 2)
					)
					((and (not (gPqPointFlags test: 29)) (not local10))
						(gGame points: 3 29)
						(gPqPointFlags set: 29)
						(gCurRoom setScript: getReportScript)
						(= local10 1)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			((OneOf theVerb 4 22) ; Do, handgun
				(gMessager say: 31 2 38 2) ; "Yes sir."
			)
			((== theVerb 27) ; badge
				(if local24
					(gMessager say: 0 27 32 0) ; "Identifying yourself again is unnecessary."
				else
					(= local24 1)
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance getReportScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((gCast contains: spiff)
						(if (< (gEgo y:) 138)
							(self setScript: (ScriptID 100 4) self) ; underTapeScript
						else
							(= cycles 2)
						)
					)
					((> (gEgo y:) 138)
						(self setScript: (ScriptID 100 4) self) ; underTapeScript
					)
					(else
						(= cycles 2)
					)
				)
			)
			(1
				(gGame handsOff:)
				(cond
					((not (gCast contains: spiff))
						(gEgo setMotion: PolyPath 213 134 self)
					)
					((== (cop1 view:) 1011)
						(gEgo setMotion: MoveTo 216 152 self)
					)
					((or (== (cop1 view:) 1009) (== (cop1 view:) 1010))
						(= local2 1)
						(gEgo setMotion: MoveTo 189 152 self)
					)
				)
			)
			(2
				(if (gCast contains: spiff)
					(gEgo setHeading: 0 self)
				else
					(gEgo setHeading: 125 self)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 31 2 26 0 self) ; "Officer Woodbury, I'm taking over as lead investigator."
			)
			(5
				(= cycles 2)
			)
			(6
				(if (== (cop1 view:) 1011)
					(cop1 setCycle: End self)
				else
					(cop1
						view: 1009
						x: 208
						y: 154
						loop: 0
						cel: 7
						setCycle: CT 9 1 self
					)
				)
			)
			(7
				(if (gCast contains: spiff)
					(gEgo
						view: 9033
						setLoop: 0 1
						cel: 0
						setCycle: CT 6 1 self
					)
				else
					(gEgo view: 9035 setLoop: 0 1 cel: 0 setCycle: End self)
				)
			)
			(8
				(gEgo get: 47) ; crimeSceneReport
				(cop1 setCycle: Beg)
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo
					heading: (if (gCast contains: spiff) 0 else 125)
					normalize: 0
				)
				(= cycles 4)
			)
			(10
				(= local2 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance signLight of View
	(properties
		x 25
		y 4
		view 17
	)
)

(instance garageLight of View
	(properties
		x 151
		y 45
		view 17
		loop 1
	)
)

(instance billboardLight of View
	(properties
		noun 41
		x 242
		y 63
		view 17
		loop 2
	)
)

(instance body of View
	(properties
		noun 25
		approachX 188
		approachY 131
		approachDist 30
		x 183
		y 130
		priority 126
		fixPriority 1
		view 10
	)

	(method (doVerb theVerb)
		(if local8
			(gMessager say: 25 1 33 0) ; "Follow protocol, Carey. The Deputy Coroner has a job to do."
		else
			(switch theVerb
				(4 ; Do
					(gMessager say: 25 4 0 0) ; "Detective Carey, have you found evidence you need recorded?"
				)
				(1 ; Look
					(gCurRoom setScript: (ScriptID 100 5) 0 0) ; toObjectScript
				)
				(38 ; caseChalk
					(if (gPqPointFlags test: 3)
						(gMessager say: 0 38 32 0) ; "Rechalking is unnecessary."
					else
						(gCurRoom setScript: chalkBodyScript)
					)
				)
				(52 ; notebook
					(if (gPqPointFlags test: 1)
						(gMessager say: 0 52 32 0) ; "This information is already recorded."
					else
						(gCurRoom setScript: (ScriptID 100 1) 0 0) ; scribbleScript
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance bodyInset of Inset
	(properties
		picture 105
		disposeNotOnMe 1
		noun 27
	)

	(method (init)
		(gGame fade: 100 0 10)
		(super init: &rest)
		(gGame handsOn:)
		(gTheIconBar disable: 3 7 6)
		(Platform 0 2 1)
		(gGame fade: 0 100 10)
	)

	(method (drawInset)
		(super drawInset:)
		(PalVary 8 105) ; PalVaryNewSource
		(if (gPqPointFlags test: 3)
			(hickOutline init: signal: (| (hickOutline signal:) $1000))
		)
		(cig view: (if (gPqPointFlags test: 4) 124 else 122))
		(cig cel: (cig lastCel:) init: signal: (| (cig signal:) $4000))
		(holster init:)
		(gGlobalSound0 stop:)
		(rmMusic number: 250 loop: -1 flags: 1 play:)
		(self setScript: bodyInsetScript)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 55 (param1 x:) 269) (<= 5 (param1 y:) 145)))
	)

	(method (dispose)
		(gTheIconBar enable: 0 3 7 show: 0)
		(gGame fade: 100 0 10)
		(if (gCast contains: hickOutline)
			(hickOutline dispose:)
		)
		(super dispose:)
		(PalVary 8 100) ; PalVaryNewSource
		(FrameOut)
		(gGame fade: 0 100 10)
		(rmMusic fade: 0 1 1 1)
		(gGlobalSound0 number: 100 loop: -1 play:)
		(Platform 0 2 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; notebook
				(if (gPqPointFlags test: 1)
					(gMessager say: 0 52 32 0) ; "This information is already recorded."
				else
					(gGame points: 3 1)
					(gPqPointFlags set: 1)
					(gMessager say: 27 52 0 0) ; "Recording information at the crime scene ensures accurate reports later."
				)
			)
			(38 ; caseChalk
				(if (gPqPointFlags test: 3)
					(gMessager say: 0 38 32 0) ; "Rechalking is unnecessary."
				else
					(self dispose:)
					(gCurRoom setScript: chalkBodyScript)
				)
			)
			(2 ; Talk
				(gMessager say: 25 2 0 0) ; "Your friend can no longer communicate, Carey."
			)
			(4 ; Do
				(gMessager say: 27 4 19 0) ; "Detective Carey, have you found evidence you need recorded?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cig of Prop
	(properties
		noun 36
		x 159
		y 129
		view 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(38 ; caseChalk
				(if (gPqPointFlags test: 4)
					(gMessager say: 0 38 32 0) ; "Rechalking is unnecessary."
				else
					(= local6 1)
					(gGame points: 4 4)
					(gPqPointFlags set: 4)
					(gCurRoom setScript: chalkCigScript)
				)
			)
			(52 ; notebook
				(if (gPqPointFlags test: 2)
					(gMessager say: 0 52 32 0) ; "This information is already recorded."
				else
					(gGame points: 3 2)
					(gPqPointFlags set: 2)
					(gMessager say: 36 52 0 0) ; "Noting that a cigarette lay near the body could prove important later."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chalkCigScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cig view: 124 cel: 0 setCycle: End self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 36 38 0 0 self) ; "This cigarette could be evidence."
			)
			(3
				(gGame handsOn:)
				(gTheIconBar disable: 0 3 7 6 show: 0)
				(self dispose:)
			)
		)
	)
)

(instance chalkBodyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (gEgo y:) 138)
					(self setScript: (ScriptID 100 4) self) ; underTapeScript
				else
					(= cycles 2)
				)
			)
			(1
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 188) (!= (gEgo y:) 131))
					(gEgo setMotion: PolyPath 192 131 self)
				else
					(= cycles 2)
				)
			)
			(2
				(gGame points: 4 3)
				(gPqPointFlags set: 3)
				(= local7 1)
				(gEgo
					setScaler: 0
					view: 9041
					setLoop: 0 1
					setPri: (+ (body priority:) 1)
					cel: 0
					x: 172
					y: 104
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(4
				(body loop: 1)
				(gEgo
					setScaler: Scaler 81 17 140 89
					x: 188
					y: 131
					setPri: -1
					heading: 315
					normalize: 0
				)
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hickOutline of Prop
	(properties
		noun 42
		x 153
		y 116
		view 123
	)
)

(instance bodyInsetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 27 0 14 0 self) ; "The tortured and tormented body of Bob Hickman, LAPD, lies lifeless among the alley debris. An obvious case of felonious homicide."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance washInset of Inset
	(properties
		picture 108
		disposeNotOnMe 1
		noun 35
	)

	(method (init)
		(gGame fade: 100 0 10)
		(super init: &rest)
		(gGame handsOn:)
		(gTheIconBar disable: 7 6)
		(Platform 0 2 1)
		(gGame fade: 0 100 10)
	)

	(method (drawInset)
		(super drawInset:)
		(PalVary 8 108) ; PalVaryNewSource
		(gGlobalSound0 stop:)
		(gPqFlags set: 8)
		(if (!= local9 1)
			(= local9 1)
		)
		(self setScript: washInsetScript)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 33 (param1 x:) 287) (<= 0 (param1 y:) 148)))
	)

	(method (dispose)
		(gTheIconBar enable: 0 7)
		(gGame fade: 100 0 10)
		(super dispose:)
		(cop1 setCycle: 0)
		(cop1 view: 1011 setLoop: 2 1 setCel: 0 x: 244 y: 152)
		(UpdateScreenItem cop1)
		(if (gCast contains: spiff)
			(spiff dispose:)
		)
		(if (gCast contains: spiffLegs)
			(spiffLegs dispose:)
		)
		(if (gCast contains: jack)
			(jack dispose:)
		)
		(PalVary 8 100) ; PalVaryNewSource
		(FrameOut)
		(gGame fade: 0 100 10)
		(if (not local23)
			(gCurRoom setScript: bodMessScript)
		)
		(Platform 0 2 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; notebook
				(if (gPqPointFlags test: 7)
					(gMessager say: 0 52 32 0) ; "This information is already recorded."
				else
					(= global152 1)
					(gGame points: 2 7)
					(gPqPointFlags set: 7)
					(gMessager say: 27 52 0 0) ; "Recording information at the crime scene ensures accurate reports later."
				)
			)
			(38 ; caseChalk
				(gMessager say: noun theVerb 0 0) ; "The body rests on garbage. It's impossible to chalk."
			)
			(4 ; Do
				(gMessager say: noun theVerb 19 0) ; "Detective Carey, have you found something?"
			)
			(2 ; Talk
				(= local23 1)
				(gMessager say: noun theVerb 0 0) ; "Nobles, Chester.... we have another body!"
			)
			(43 ; caseFlashlight
				(gMessager say: noun 1 0 3) ; "There's enough light to see by. Save your batteries."
			)
			(1 ; Look
				(gMessager sayRange: noun theVerb 0 1 2) ; "Bullet wounds puncture the boy's body."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance washInsetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 5 6)
				(gPqPointFlags set: 6)
				(rmMusic number: 104 loop: 1 play: self)
				(= ticks 30)
			)
			(1
				(gMessager say: 35 0 14 0 self) ; "The body of a young boy lies strewn in the dumpster."
			)
			(2)
			(3
				(rmMusic fade: 0 1 1 1)
				(gGlobalSound0 number: 100 loop: -1 play:)
			)
			(4
				(= cycles 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance bodMessScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(gMessager say: 35 4 19 0 self) ; "Detective Carey, have you found something?"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance tape of View
	(properties
		noun 28
		x 47
		y 95
		priority 139
		fixPriority 1
		view 12
	)
)

(instance rmMusic of Sound
	(properties)
)

(instance carSFX of Sound ; UNUSED
	(properties)
)

(instance rmSFX of Sound
	(properties)
)

(instance womanScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spiff setScript: spiffScript)
				(woman setCycle: End self)
				(= cycles 2)
			)
			(1
				(jack setScript: jackScript)
				(= ticks 60)
			)
			(2
				(rmMusic fade: 0 10 1 1)
				(cop2
					view: 1006
					setLoop: 0 1
					cel: 0
					posn: 58 142
					setCycle: End self
				)
				(cop2Legs dispose:)
			)
			(3
				(cop2 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(4
				(cop2Legs
					view: 1005
					setLoop: 3 1
					posn: 54 142
					init:
					signal: (| (cop2Legs signal:) $5000)
				)
				(cop2 view: 1005 setLoop: 0 1 cel: 0 posn: 55 81)
				(= ticks 90)
			)
			(5
				(woman setLoop: 2 1 setCel: 0 posn: 108 148 setCycle: End self)
			)
			(6
				(woman
					setLoop: 3 1
					cel: 0
					setStep: 6 2
					setCycle: Walk
					posn: 89 148
					setMotion: MoveTo -30 148 self
				)
			)
			(7
				(gGlobalSound0 number: 100 loop: -1 play:)
				(woman dispose:)
				(= temp0 (Str newWith: 400 {}))
				(Message msgGET 100 10 0 1 1 (temp0 data:)) ; "Monday 3:30 A.M. South Central, Los Angeles"
				(= temp1 (temp0 size:))
				(= ticks (Max 240 (* (/ (* 24 temp1) 10) gTextSpeed)))
				(proc45_1)
				(Print
					fore: 28
					back: -1
					shadowText: 1
					modeless: 2
					mode: 1
					addText: temp0
					plane: TransPlane
					init:
				)
				(temp0 dispose:)
			)
			(8
				(if (Print dialog:)
					((Print dialog:) dispose:)
				)
				(proc45_2)
				(= ticks 60)
			)
			(9
				(gMessager sayRange: 10 0 1 2 14 self) ; "John, lemme warn you... it's bad, real bad. It's Hickman."
				(cop2 setScript: cop2Script)
			)
			(10
				(coroner
					view: 106
					setLoop: 0 1
					setCel: 0
					setStep: 4 2
					setCycle: Walk
					setMotion: MoveTo 232 134 self
				)
			)
			(11
				((ScriptID 100 9) x: 100) ; coronerTalker
				((ScriptID 100 8) x: 10) ; careyTalker
				(coroner view: 107 setCel: 0 setLoop: 1 1)
				(= cycles 2)
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance manNoSober of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(jack view: 103 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(2
				(jack setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(3
				(= state -1)
				(= seconds (Random 2 7))
			)
		)
	)
)

(instance jackScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(jack view: 103 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(2
				(jack setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(3
				(cop1 view: 1009 setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(4
				(cop1 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(5
				(cop1 setCycle: Beg self)
			)
			(6
				(cop1 setLoop: 0 1)
				(cop1 cel: (cop1 lastCel:) setCycle: Beg self)
			)
			(7
				(if local2
					(-- state)
				)
				(= seconds 2)
			)
			(8
				(jack setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(9
				(cop1
					view: 1010
					setLoop: 0 1
					cel: 0
					x: (+ (cop1 x:) 9)
					setCycle: End self
				)
			)
			(10
				(jack setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(11
				(= seconds 2)
			)
			(12
				(cop1 setCycle: Beg self)
			)
			(13
				(if local2
					(-- state)
					(= ticks 60)
				else
					(self setScript: manNoSober)
					(= seconds (if local1 15 else 180))
				)
			)
			(14
				(if (and local29 (not local1))
					(= state 12)
					(= cycles 2)
				else
					(manNoSober dispose:)
					(= local3 1)
					(jack view: 104 setLoop: 0 1 setCel: 0 setPri: 171)
					(= ticks 15)
				)
			)
			(15
				(jack
					setLoop: 0 1
					setCel: 1
					posn: (+ (jack x:) 8) (+ (jack y:) 1)
					setCycle: CT 2 1 self
				)
			)
			(16
				(= ticks 10)
			)
			(17
				(jack setCel: 3 posn: (+ (jack x:) 12) (+ (jack y:) 1))
				(= ticks 10)
			)
			(18
				(jack
					view: 105
					setLoop: 0 1
					setCel: 11
					x: (- (jack x:) 7)
					setCycle: Walk
					setScaler: Scaler 140 100 189 145
					setMotion: MoveTo 279 169 self
				)
			)
			(19
				(jack setMotion: MoveTo 330 176 self)
			)
			(20
				(jack dispose:)
			)
		)
	)
)

(instance spiffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(spiff view: 1000 setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(2
				(= seconds 10)
			)
			(3
				(spiff view: 1001 cel: 0 setCycle: End self)
			)
			(4
				(= seconds 10)
			)
			(5
				(spiffLegs
					view: 1002
					setLoop: 2 1
					posn: 303 170
					init:
					signal: (| (spiffLegs signal:) $5000)
				)
				(spiff
					view: 1002
					setLoop: 0 1
					cel: 0
					posn: 303 124
					setCycle: End self
				)
			)
			(6
				(= seconds 10)
			)
			(7
				(spiff view: 1002 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(8
				(spiffLegs dispose:)
				(spiff view: 1003 setLoop: 0 1 setCel: 0 posn: 303 170)
				(UpdateScreenItem spiff)
				(= seconds 10)
			)
			(9
				(spiff setCycle: End self)
			)
			(10
				(spiff setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(11
				(= seconds 10)
			)
			(12
				(spiffLegs
					view: 1004
					setLoop: 1 1
					posn: 303 169
					init:
					signal: (| (spiffLegs signal:) $5000)
				)
				(spiff
					view: 1004
					setLoop: 0 1
					cel: 0
					posn: 301 126
					setCycle: End self
				)
			)
			(13
				(= seconds 8)
			)
			(14
				(= cycles 2)
			)
			(15
				(spiff
					view: 1004
					setLoop: 0 1
					posn: 301 126
					cel: 14
					setCycle: Beg self
				)
			)
			(16
				(= seconds 6)
			)
			(17
				(spiffLegs dispose:)
				(spiff
					view: 1003
					setLoop: 1 1
					posn: 303 170
					cel: 2
					setCycle: Beg self
				)
				(UpdateScreenItem spiff)
			)
			(18
				(spiff
					view: 1003
					setLoop: 0 1
					posn: 303 170
					cel: 13
					setCycle: Beg self
				)
			)
			(19
				(= seconds 8)
			)
			(20
				(spiff
					view: 1002
					setLoop: 1 1
					posn: 303 124
					cel: 13
					setCycle: Beg self
				)
				(spiffLegs
					view: 1002
					setLoop: 2 1
					posn: 303 170
					init:
					signal: (| (spiffLegs signal:) $5000)
				)
			)
			(21
				(= seconds 8)
			)
			(22
				(spiff
					view: 1002
					setLoop: 0 1
					posn: 303 124
					cel: 14
					setCycle: Beg self
				)
			)
			(23
				(= seconds 2)
			)
			(24
				(spiffLegs dispose:)
				(spiff view: 1001 posn: 303 170 cel: 13 setCycle: Beg self)
				(UpdateScreenItem spiff)
			)
			(25
				(= cycles 2)
			)
			(26
				(spiff
					view: 1000
					setLoop: 0 1
					posn: 303 170
					cel: 13
					setCycle: Beg self
				)
			)
			(27
				(= state 0)
				(= ticks 30)
			)
		)
	)
)

(instance cop2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= seconds (Random 3 7))
			)
			(2
				(cop2
					view: 1005
					cycleSpeed: 0
					setLoop: 0 1
					cel: 0
					setCycle: End self
				)
			)
			(3
				(= seconds 3)
			)
			(4
				(cop2 view: 1005 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(5
				(= seconds 3)
			)
			(6
				(cop2 view: 1005 setLoop: 2 1 cel: 0 setCycle: End self)
				(= state 0)
			)
		)
	)
)

(instance helper of Actor
	(properties
		noun 38
		x -20
		y 148
		view 150
	)
)

(instance helperScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 1)
				(= cycles 2)
			)
			(1
				(helper
					setCycle: Walk
					scaleSignal: 1
					scaleX: 112
					scaleY: 112
					setStep: 4 2 0
					init:
					signal: (| (helper signal:) $4800)
					setMotion: MoveTo 172 142 self
				)
			)
			(2
				(helper
					view: 158
					loop: 0
					cel: 0
					x: (+ (helper x:) 25)
					y: (+ (helper y:) 1)
					setCycle: End self
				)
			)
			(3
				(helper loop: 1 cel: 0 setCycle: CT 8 1 self)
			)
			(4
				(helper setPri: (- (tape priority:) 1) setCycle: End self)
			)
			(5
				(helper loop: 2 cel: 0 setCycle: End self)
			)
			(6
				(helper
					view: 152
					loop: 0
					cel: 0
					x: (+ (helper x:) 21)
					y: (- (helper y:) 12)
					scaleX: 95
					scaleY: 95
					setPri: -1
					setCycle: End self
				)
			)
			(7
				(helper loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(coroner
					view: 106
					setLoop: 1 1
					setCycle: Walk
					signal: (| (coroner signal:) $4000)
					setMotion: MoveTo 150 134 self
				)
			)
			(9
				(coroner view: 107 loop: 3)
				(= cycles 4)
			)
			(10
				(coroner loop: 0)
				(= cycles 4)
			)
			(11
				(helper
					view: 153
					loop: 0
					cel: 0
					x: (- (helper x:) 15)
					scaleX: 95
					scaleY: 95
					setCycle: End self
				)
			)
			(12
				(helper loop: 1 cel: 0 setCycle: End self)
			)
			(13
				(helper loop: 2 cel: 0 setCycle: End self)
			)
			(14
				(coroner
					view: 109
					loop: 0
					cel: 0
					x: (+ (coroner x:) 22)
					y: (- (coroner y:) 2)
					setCycle: End self
				)
			)
			(15
				(helper view: 154 loop: 1 cel: 0 setCycle: End)
				(coroner loop: 1 cel: 0 setCycle: End self)
			)
			(16
				(= ticks 30)
			)
			(17
				(rmMusic fade: 0 1 1 1)
				(gPqPointFlags set: 24)
				(gMessager say: 33 0 36 0 self) ; "John, we can handle it from here. Stop by tomorrow for the autopsy. We'll know more then."
			)
			(18
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance flash of View
	(properties
		view 1038
	)
)

(instance crim of Actor
	(properties
		heading 135
		noun 32
		x 111
		y 125
		view 1023
		loop 4
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local4)
					(++ local4)
					(gMessager say: 32 4 25 0) ; "Detective Carey, sexual harassment is a violation of Federal and State law and of City and Department policy."
				else
					(gMessager say: 32 4 20 0) ; "Sexual harassment is viewed by the Department as serious misconduct with disciplinary action up to and including termination! Please stop."
				)
			)
			(2 ; Talk
				(if (and (not local15) (gPqFlags test: 163))
					(= local15 1)
				)
				(cond
					((and (gPqPointFlags test: 6) (not local31))
						(gMessager say: noun 2 38 0) ; "It looks like it's going to be a busy night for you, Chester."
						(= local31 1)
					)
					((not local15)
						(= local15 1)
						(gMessager say: 32 2 39 0) ; "Hello, Chester, thanks for coming out."
					)
					(
						(or
							(== local6 1)
							(== local7 1)
							(== global140 1)
							(== global152 1)
						)
						(crim setScript: doEvidenceScript)
					)
					(else
						(gMessager say: 32 2 28 0) ; "Standing by, Detective Carey. Ready to collect samples or evidence, if needed."
					)
				)
			)
			(27 ; badge
				(if local27
					(gMessager say: 0 27 32 0) ; "Identifying yourself again is unnecessary."
				else
					(= local27 1)
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance getCigScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(crim view: 1026 setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance snapScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(crim
					view: 1024
					x:
						(if (== (doEvidenceScript register:) 1)
							(- (crim x:) 3)
						else
							(crim x:)
						)
					setLoop: 0 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(flash
					loop:
						(switch (doEvidenceScript register:)
							(1 0)
							(2 1)
							(4 2)
						)
					x:
						(switch (doEvidenceScript register:)
							(1 100)
							(2 152)
							(4 184)
						)
					y:
						(switch (doEvidenceScript register:)
							(1 136)
							(2 119)
							(4 130)
						)
					init:
				)
				(FrameOut)
				(flash dispose:)
				(rmSFX number: 918 loop: 1 play:)
				(crim setCycle: Beg self)
			)
			(3
				(crim setCycle: End self)
			)
			(4
				(flash init:)
				(FrameOut)
				(flash dispose:)
				(rmSFX play:)
				(crim setCycle: Beg self)
			)
			(5
				(if (== (doEvidenceScript register:) 1)
					(crim x: (+ (crim x:) 3))
				)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance moveEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 102 134 self)
				((ScriptID 100 8) x: 10) ; careyTalker
			)
			(1
				(gEgo setHeading: 44 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance doEvidenceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (gEgo y:) 138)
					(self setScript: (ScriptID 100 4) self) ; underTapeScript
				else
					(= cycles 2)
				)
			)
			(1
				(gGame handsOff:)
				(= local16 1)
				(= register 0)
				(self setScript: moveEgoScript self)
			)
			(2
				(gMessager say: 32 2 29 0 self) ; "Chester, take over on the evidence."
			)
			(3
				(if
					(or
						(and (gPqPointFlags test: 0) (< global140 2))
						(and (gPqPointFlags test: 7) (< global152 2))
						(== local7 1)
						(== local6 1)
					)
					(localproc_0)
					(if (!= register 1)
						(localproc_0)
						(crim
							setCycle: Walk
							ignoreActors: 1
							setMotion: PolyPath 133 124 self
						)
					)
				else
					(= cycles 2)
				)
			)
			(4
				(gGame handsOff:)
				(cond
					((and (gPqPointFlags test: 0) (< global140 2))
						(= global140 2)
						(= register 1)
						(localproc_0)
						(crim setMotion: PolyPath 119 128 self)
					)
					((and (gPqPointFlags test: 7) (< global152 2))
						(localproc_0)
						(= global152 2)
						(= register 2)
						(crim setMotion: PolyPath 181 115 self)
					)
					((== local7 1)
						(= local7 2)
						(= register 4)
						(localproc_0)
						(crim setMotion: PolyPath 211 128 self)
					)
					((== local6 1)
						(= local6 2)
						(= register 3)
						(localproc_0)
						(crim setMotion: PolyPath 182 129 self)
					)
					((and (> local6 1) (> local7 1) (> global140 1))
						(= register 6)
						(crim setHeading: 90 self)
					)
					(
						(and
							(!= global140 1)
							(!= local6 1)
							(!= local7 1)
							(!= global152 1)
						)
						(= register 5)
						(localproc_0)
						(crim setMotion: PolyPath 115 130 self)
					)
				)
			)
			(5
				(if (== register 6)
					(if (and (== (crim view:) 1026) (!= (crim loop:) 1))
						(-- state)
						(crim cel: 0 setLoop: 1 setCycle: End self)
					else
						(gMessager say: 25 0 29 0 self) ; "Whenever you're ready, fellows, I'm finished."
					)
				else
					(= cycles 2)
				)
			)
			(6
				(if (== register 5)
					(crim setMotion: MoveTo 111 125 self)
				else
					(= cycles 2)
				)
			)
			(7
				(cond
					((or (== register 1) (== register 2) (== register 4))
						(self setScript: snapScript self)
					)
					((== register 3)
						(self setScript: getCigScript self)
					)
					((== register 5)
						(crim setHeading: 115 self)
					)
					((== register 6)
						(localproc_0)
						(crim setMotion: PolyPath 133 124 self)
					)
				)
			)
			(8
				(if (== register 5)
					(crim setMotion: MoveTo 111 125 self)
				else
					(= cycles 2)
				)
			)
			(9
				(cond
					(
						(or
							(== register 1)
							(== register 2)
							(== register 4)
							(== register 3)
						)
						(= state 3)
						(= register 0)
						(= cycles 2)
					)
					((== register 5)
						(gGame handsOn:)
						(= local16 0)
						(self dispose:)
					)
					((== register 6)
						(crim setHeading: 90 self)
					)
				)
			)
			(10
				(if (== register 5)
					(gGame handsOn:)
					(= local16 0)
					(self dispose:)
				else
					(= cycles 2)
				)
			)
			(11
				(gCurRoom setScript: helperScript)
				(= local16 0)
				(self dispose:)
			)
		)
	)
)

