;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use n030)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	local0
	local1
	local2
)

(instance rm390 of Room
	(properties
		noun 2
		picture 390
	)

	(method (init)
		(gEgo get: 33 11) ; handcuffs
		(gGame handsOff:)
		(super init: &rest)
		(if (!= (gGlobalSound0 number:) 1027)
			(gGlobalSound0 number: 1027 loop: -1 play:)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 142 146 177 146 171 129 148 129
					yourself:
				)
		)
		(gEgo
			view: 0
			setHeading: 0
			normalize: 0
			posn: 165 145
			setScaler: Scaler 120 80 145 130
			init:
		)
		(gEgo scaleSignal: (| (gEgo scaleSignal:) $0004) setStep: 3 1)
		(femCrowd init:)
		(maleCrowd init:)
		(greg init:)
		(coun1 init:)
		(coun2 init:)
		(coun3 init:)
		(metzler init:)
		(kristy init:)
		(barry init:)
		(coun4 init:)
		(mayor init:)
		(gWalkHandler addToFront: self)
		(self setScript: mayorCalls)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (< (gEgo y:) 135) (not local0))
				(self setScript: goToPodium)
			)
			((self script:) 0)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(cond
				(local1
					(gMessager say: 2 3 7 0) ; "Your responsibility is to protect the public! Get to work!"
					(event claimed: 1)
					(return)
				)
				(local0
					(gMessager sayRandom: 6 2 5)
					(event claimed: 1)
					(return)
				)
				(else
					(event claimed: 0)
					(return)
				)
			)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (cue)
		(self setScript: askQuestion)
	)
)

(instance mayorCalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 450)
			)
			(1
				(gMessager say: 6 2 6 1 self) ; "Detective Carey, please step up to the podium."
			)
			(2
				(= ticks 450)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance goToPodium of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 163 130 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame handsOn:)
				(= local2 0)
				(gCurRoom setScript: askQuestion)
				(self dispose:)
			)
		)
	)
)

(instance filmFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kristy view: 3902 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(kristy loop: 1 cel: 0 setCycle: End)
				(barry view: 396 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(barry loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance askQuestion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< local2 8)
					(++ local2)
				)
				(switch local2
					(1
						(gNarrator x: 100 y: 25)
						(self setScript: delQuestion self)
					)
					(2
						(gNarrator x: 1 y: 30)
						(gMessager say: 8 2 0 1 self) ; "Hey, Carey! If the cops can't protect themselves, how are they going to protect me and my family!?"
					)
					(3
						(gNarrator x: 50 y: 40)
						(gMessager say: 4 2 0 1 self) ; "Detective! We need protection! What is the police doing about that?"
					)
					(4
						(gNarrator x: 120 y: 40)
						(gMessager say: 7 2 0 1 self) ; "Detective Carey, I own a business, and I'm afraid to stay open at night now! Is the police department stepping up patrols?"
					)
					(5
						(gNarrator x: 1 y: 40)
						(gMessager say: 8 2 0 3 self) ; "Carey! Are my children safe? How do I know this murdering wacko isn't a cop?"
					)
					(6
						(gNarrator x: 120 y: 30)
						(self setScript: bildenQuestion self)
					)
					(7
						(gNarrator x: 120 y: 20)
						(gMessager say: 7 2 0 4 self) ; "Mr. Mayor, I think this city is going to hell! As a business owner, I'm confronted with vandalism and theft everyday! Now I have to worry about some crazy cop killer! What's this city coming to!?"
					)
					(8
						(gNarrator x: -1 y: 5)
						(self setScript: mayorQuestion self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gNarrator x: -1)
				(gGame handsOn:)
				(cond
					((>= local2 8)
						(gCurRoom setScript: metzAttack)
					)
					((> gHowFast 6)
						(= ticks 300)
					)
					(else
						(= ticks 120)
					)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance delQuestion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kristy setCycle: CT 5 1)
				(coun4 setCycle: End self)
			)
			(1
				(gMessager say: 3 2 0 1 self) ; "Detective Carey! My constituents are frightened and want answers! What is the status of your investigation?"
			)
			(2
				(= ticks 120)
			)
			(3
				(coun4 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(kristy setCycle: End)
				(coun4 loop: 2 cel: 0 setCycle: End self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance bildenQuestion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kristy loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 5 2 0 1 self) ; "Detective Carey, Kristy Bilden with KKAT. What can you tell us about the body found in Griffith Park this morning?"
			)
			(2
				(gNarrator x: 120 y: 10)
				(gMessager say: 5 2 0 2 self) ; "From what we understand, the victim was not a police officer, which would indicate that this killer is not necessarily targeting one group. Your comments, please!"
			)
			(3
				(= ticks 120)
			)
			(4
				(kristy loop: 2 cel: 0 setCycle: End self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance mayorQuestion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mayor setCycle: End self)
			)
			(1
				(gMessager say: 6 2 0 1 self) ; "Detective Carey, two Los Angeles police officers have been killed in as many days. The citizens of this city are in fear over the threat to the police and how this is affecting their safety."
			)
			(2
				(gNarrator x: -1 y: 25)
				(gMessager say: 6 2 0 2 self) ; "Detective Carey! What are you doing to find this murderer, and are our citizens' fears justified?"
			)
			(3
				(mayor setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance metzAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> gHowFast 6)
					(= ticks 1000)
				else
					(= ticks 400)
				)
			)
			(1
				(kristy setScript: filmFight)
				(= local1 1)
				(gGlobalSound0 number: 102 loop: 1 play:)
				(metzler setCycle: End self)
			)
			(2
				(if (> gHowFast 6)
					(= ticks 300)
				else
					(= ticks 120)
				)
			)
			(3
				(gGame handsOff:)
				(gEgo setCycle: 0)
				((gEgo looper:) dispose:)
				(gEgo looper: 0)
				(= cycles 2)
			)
			(4
				(gEgo view: 399 setLoop: 4 1 cel: 0)
				(UpdateScreenItem gEgo)
				(metzler
					view: 390
					loop: 1
					cel: 0
					setPri: (+ (gEgo priority:) 1)
					setCycle: CT 4 1 self
				)
			)
			(5
				(proc30_0 1 0 1 1 390)
				(self dispose:)
			)
		)
	)
)

(instance pullGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 3)
				(if (!= (metzler cel:) (metzler lastCel:))
					(metzler setCycle: End)
				)
				(gEgo
					setScale: 0
					view: 9390
					loop: 0
					cel: 0
					x: 145
					setCycle: End self
				)
			)
			(1
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gCurRoom setScript: stickScr)
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
				(if (> gHowFast 6)
					(= ticks 400)
				else
					(= ticks 180)
				)
			)
			(1
				(gGame handsOff:)
				(metzler
					view: 390
					loop: 1
					cel: 0
					setPri: (+ (gEgo priority:) 1)
					setCycle: CT 4 1 self
				)
			)
			(2
				(proc30_0 1 0 1 1 390)
				(self dispose:)
			)
		)
	)
)

(instance dropStick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 4)
				(gEgo view: 9391 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 1 2 3 1 self) ; "Drop the stick! Put your hands behind your head!"
			)
			(2
				(gEgo loop: 1 cel: 0 setCycle: End self)
				(metzler view: 391 loop: 0 cel: 0 setCycle: End self)
			)
			(3 0)
			(4
				(metzler loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(gGame handsOn:)
				(if (> gHowFast 6)
					(= ticks 300)
				else
					(= ticks 120)
				)
			)
			(6
				(gGame handsOff:)
				(metzler setCycle: CT 5 -1 self)
			)
			(7
				(proc30_0 1 0 1 1 390)
				(self dispose:)
			)
		)
	)
)

(instance turnMetz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 4)
				(gEgo view: 9392 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 1 2 4 1 self) ; "Turn around! Get down on your knees! Keep your hands where I can see them!"
			)
			(2
				(metzler view: 392 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(metzler loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo loop: 1 cel: 0 setCycle: End)
				(metzler view: 393 loop: 0 cel: 0 setCycle: End self)
			)
			(5
				(gGame handsOn:)
				(cond
					((== (Platform) 2)
						(if (> gHowFast 6)
							(= ticks 9000)
						else
							(= ticks 600)
						)
					)
					((> gHowFast 6)
						(= ticks 6000)
					)
					(else
						(= ticks 420)
					)
				)
			)
			(6
				(gGame handsOff:)
				(gEgo setCycle: Beg)
				(metzler setCycle: Beg self)
			)
			(7
				(metzler view: 392 loop: 1 cel: 8 setCycle: Beg self)
			)
			(8
				(metzler loop: 0 cel: 11 setCycle: Beg self)
			)
			(9
				(metzler view: 391 loop: 1 cel: 8 setCycle: CT 5 -1 self)
			)
			(10
				(proc30_0 1 0 1 1 390)
				(self dispose:)
			)
		)
	)
)

(instance cuffMetz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 3)
				(gEgo view: 9393 loop: 0 cel: 0 x: 169 setCycle: End self)
				(metzler view: 393 loop: 1 cel: 0)
			)
			(1
				(gEgo cycleSpeed: 6 loop: 1 cel: 0 setCycle: CT 4 1 self)
				(metzler view: 393 loop: 1 cel: 0)
			)
			(2
				(gEgo setCycle: CT 7 1 self)
				(metzler setCycle: CT 3 1 self)
			)
			(3 0)
			(4
				(gEgo setCycle: CT 10 1 self)
				(metzler setCycle: CT 4 1 self)
			)
			(5 0)
			(6
				(metzler setCycle: CT 6 1 self)
			)
			(7
				(gEgo setCycle: CT 13 1 self)
				(metzler setCycle: End self)
			)
			(8 0)
			(9
				(gEgo view: 9394 loop: 0 cel: 0 setCycle: End self)
			)
			(10
				(gEgo loop: 1 cel: 0 setCycle: CT 6 1 self)
			)
			(11
				(metzler loop: 2 cel: 0 setCycle: CT 2 1 self)
				(gEgo setCycle: CT 8 1 self)
			)
			(12 0)
			(13
				(gEgo setCycle: CT 10 1 self)
				(metzler setCycle: CT 3 1 self)
			)
			(14 0)
			(15
				(gEgo setCycle: CT 12 1 self)
				(metzler setCycle: CT 5 1 self)
			)
			(16 0)
			(17
				(walkSound number: 992 loop: 1 play:)
				(gEgo cel: 14)
				(metzler setCycle: End self)
			)
			(18
				(gGlobalSound0 number: 500 play:)
				(gEgo
					view: 9395
					loop: 0
					cel: 0
					setPri: (+ (metzler priority:) 1) 1
					cycleSpeed: 6
					setCycle: CT 4 1 self
				)
				(metzler
					view: 394
					loop: 0
					cel: 0
					setPri: (+ (gEgo priority:) 1)
					cycleSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(19 0)
			(20
				(metzler setCycle: CT 6 1 self)
			)
			(21
				(gEgo cel: 5)
				(metzler setCycle: CT 7 1 self)
			)
			(22
				(gEgo cel: 8)
				(metzler setCycle: CT 8 1 self)
			)
			(23
				(gEgo cel: 12)
				(metzler setCycle: CT 9 1 self)
			)
			(24
				(gEgo cel: 15)
				(metzler setCycle: End self)
			)
			(25
				(gEgo
					loop: 1
					cel: 0
					setPri: (- (metzler priority:) 1) 1
					setCycle: End self
				)
				(metzler view: 3941 loop: 0 cel: 0 setCycle: End self)
			)
			(26 0)
			(27
				(gPqFlags set: 100)
				(gGame fadeSpeed: 5)
				(gCurRoom newRoom: 540)
				(self dispose:)
			)
		)
	)
)

(instance metzler of Prop
	(properties
		noun 1
		sightAngle 360
		x 182
		y 128
		view 390
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch (gCurRoom script:)
					(stickScr
						(gCurRoom setScript: dropStick)
					)
					(dropStick
						(gCurRoom setScript: turnMetz)
					)
				)
			)
			(47 ; handcuffs
				(if (== (gCurRoom script:) turnMetz)
					(gCurRoom setScript: cuffMetz)
				)
			)
			(22 ; handgun
				(if local1
					(if (== (gCurRoom script:) metzAttack)
						(gCurRoom setScript: pullGun)
					else
						(gGlobalSound1 number: 926 loop: 1 play:)
						(proc30_0 1 0 2 1 390)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(if local1
					(gMessager say: noun theVerb 8 0) ; "It's Dennis Walker!"
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

(instance femCrowd of Feature
	(properties
		noun 4
		sightAngle 360
		x 69
		y 145
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 57 72 63 72 67 73 69 85 66 89 65 92 65 94 68 96 74 96 79 102 83 118 83 127 86 138 92 142 91 148 88 152 86 152 44 97 52 95 53 92 46 88 45 85 46 80
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(cond
				((not local0)
					(gMessager sayRandom: 10 2 0)
				)
				((== local2 3)
					(gCurRoom setScript: 0)
					(gMessager sayRange: noun 2 0 2 3 gCurRoom) ; "The police are on patrol, and are enforcing the law in a fair and impartial manner."
				)
				((== local2 2)
					(gCurRoom setScript: 0)
					(gMessager say: 8 2 0 2 gCurRoom) ; "The deaths that have occurred are unusual, to say the least. Please do not feel that the murder of these two officers has diminished your safety."
				)
				((== local2 5)
					(gCurRoom setScript: 0)
					(gMessager say: 8 2 0 4 gCurRoom) ; "There is no telling at this time who is doing the killing, but to blame the police for these murders is irrational and very premature."
				)
				((== local2 4)
					(gCurRoom setScript: 0)
					(gMessager sayRange: 7 2 0 2 3 gCurRoom) ; "Where the department can, they are adding patrols. However, due to budget constraints, the department has a limited number of officers, patrol vehicles, and working radios."
				)
				((== local2 7)
					(gCurRoom setScript: 0)
					(gMessager say: 7 2 0 5 gCurRoom) ; "The cosmopolitan nature of a city as large as Los Angeles is reflected in the diversity of its residents. Unfortunately, a large urban society, such as Los Angeles, free from crime and disorder remains an unachieved ideal."
				)
				((< local2 8)
					(gCurRoom setScript: askQuestion)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance maleCrowd of Feature
	(properties
		noun 7
		sightAngle 360
		x 302
		y 150
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 298 76 302 72 306 72 312 77 314 84 310 87 311 90 310 91 319 97 319 115 295 116 293 149 279 148 275 144 279 153 273 152 270 141 271 137 273 136 277 133 289 127 290 118 281 127 277 127 276 125 277 122 283 100 289 97 296 94 297 92 295 90 294 86 294 82 294 81 292 78 292 77 294 76
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(cond
				((not local0)
					(gMessager sayRandom: 10 2 0)
				)
				((== local2 4)
					(gCurRoom setScript: 0)
					(gMessager sayRange: noun 2 0 2 3 gCurRoom) ; "Where the department can, they are adding patrols. However, due to budget constraints, the department has a limited number of officers, patrol vehicles, and working radios."
				)
				((== local2 7)
					(gCurRoom setScript: 0)
					(gMessager say: noun 2 0 5 gCurRoom) ; "The cosmopolitan nature of a city as large as Los Angeles is reflected in the diversity of its residents. Unfortunately, a large urban society, such as Los Angeles, free from crime and disorder remains an unachieved ideal."
				)
				((== local2 3)
					(gCurRoom setScript: 0)
					(gMessager sayRange: 4 2 0 2 3 gCurRoom) ; "The police are on patrol, and are enforcing the law in a fair and impartial manner."
				)
				((== local2 2)
					(gCurRoom setScript: 0)
					(gMessager say: 8 2 0 2 gCurRoom) ; "The deaths that have occurred are unusual, to say the least. Please do not feel that the murder of these two officers has diminished your safety."
				)
				((== local2 5)
					(gCurRoom setScript: 0)
					(gMessager say: 8 2 0 4 gCurRoom) ; "There is no telling at this time who is doing the killing, but to blame the police for these murders is irrational and very premature."
				)
				((< local2 8)
					(gCurRoom setScript: askQuestion)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance greg of Feature
	(properties
		noun 8
		sightAngle 360
		x 29
		y 109
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 27 71 34 72 36 77 36 83 35 85 36 89 41 91 45 93 12 93 12 91 18 89 25 86 24 82 22 77 24 74
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(cond
				((not local0)
					(gMessager sayRandom: 10 2 0)
				)
				((== local2 2)
					(gCurRoom setScript: 0)
					(gMessager say: noun 2 0 2 gCurRoom) ; "The deaths that have occurred are unusual, to say the least. Please do not feel that the murder of these two officers has diminished your safety."
				)
				((== local2 5)
					(gCurRoom setScript: 0)
					(gMessager say: noun 2 0 4 gCurRoom) ; "There is no telling at this time who is doing the killing, but to blame the police for these murders is irrational and very premature."
				)
				((== local2 3)
					(gCurRoom setScript: 0)
					(gMessager sayRange: 4 2 0 2 3 gCurRoom) ; "The police are on patrol, and are enforcing the law in a fair and impartial manner."
				)
				((== local2 4)
					(gCurRoom setScript: 0)
					(gMessager sayRange: 7 2 0 2 3 gCurRoom) ; "Where the department can, they are adding patrols. However, due to budget constraints, the department has a limited number of officers, patrol vehicles, and working radios."
				)
				((== local2 7)
					(gCurRoom setScript: 0)
					(gMessager say: 7 2 0 5 gCurRoom) ; "The cosmopolitan nature of a city as large as Los Angeles is reflected in the diversity of its residents. Unfortunately, a large urban society, such as Los Angeles, free from crime and disorder remains an unachieved ideal."
				)
				((< local2 8)
					(gCurRoom setScript: askQuestion)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance coun1 of Feature
	(properties
		sightAngle 360
		x 241
		y 111
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 292 77 298 76 304 72 308 75 313 81 311 87 309 91 314 94 319 94 319 117 311 116 311 107 307 103 298 102 294 103 293 152 275 152 270 140 274 135 280 133 276 126 282 103 285 99 293 96 297 94 293 89 294 84 296 81 293 79
				yourself:
			)
		)
	)
)

(instance coun2 of Feature
	(properties
		sightAngle 360
		x 221
		y 112
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 243 79 246 80 247 85 253 88 253 92 237 93 237 89 239 86 240 82 241 79
				yourself:
			)
		)
	)
)

(instance coun3 of Feature
	(properties
		sightAngle 360
		x 200
		y 109
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 215 92 216 88 220 86 220 83 220 80 224 77 226 77 229 80 229 83 232 87 234 92 234 93 216 94
				yourself:
			)
		)
	)
)

(instance coun4 of Prop
	(properties
		noun 3
		sightAngle 360
		x 121
		y 104
		view 399
		signal 16385
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(cond
				((not local0)
					(gMessager sayRandom: 10 2 0)
				)
				((== local2 1)
					(gCurRoom setScript: 0)
					(gMessager sayRange: noun 2 0 2 3 gCurRoom) ; "Councilman De La Cruz, certain aspects of the investigation cannot be discussed publicly without jeopardizing the case."
				)
				((< local2 8)
					(gCurRoom setScript: askQuestion)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance kristy of Prop
	(properties
		noun 5
		sightAngle 360
		x 271
		y 97
		view 3901
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(cond
				((not local0)
					(gMessager sayRandom: 10 2 0)
				)
				((== local2 6)
					(gCurRoom setScript: 0)
					(gMessager say: noun 2 0 3 gCurRoom) ; "Miss Bilden, I was briefed about the homicide just this morning as I entered this council meeting. I have not yet been able to confirm or refute its relationship to my current investigation."
				)
				((< local2 8)
					(gCurRoom setScript: askQuestion)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance barry of Prop
	(properties
		noun 9
		sightAngle 360
		x 257
		y 96
		view 396
		signal 16385
	)
)

(instance mayor of Prop
	(properties
		noun 6
		sightAngle 360
		x 149
		y 82
		view 3990
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(cond
				((not local0)
					(gMessager say: 6 2 6 1) ; "Detective Carey, please step up to the podium."
				)
				((== local2 8)
					(gCurRoom setScript: 0)
					(++ local2)
					(gMessager sayRange: noun 2 0 3 4 gCurRoom) ; "Mr. Mayor, the police department has always had to deal with the threat of violence. Tragically, someone has now moved from thought to deed."
				)
				((< local2 8)
					(gCurRoom setScript: askQuestion)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance walkSound of Sound
	(properties)
)

