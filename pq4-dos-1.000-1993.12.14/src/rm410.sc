;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm410 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7 = 1
	local8
	local9
)

(instance rm410 of Room
	(properties
		noun 1
		picture 410
	)

	(method (init)
		(gGame handsOff:)
		(proc0_4 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 16 146 128 146 127 161 177 162 178 146 303 146 303 126 226 126 226 140 86 140 86 126 16 126
					yourself:
				)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(405
				(gEgo
					setHeading: 360
					normalize: 9120
					posn: 160 147 0
					setScaler: Scaler 100 83 153 118
					init:
				)
				(self setScript: from405Scr)
			)
			(else
				(= local8 1)
				(= local0 1)
				(gEgo
					setHeading: 270
					normalize: 9120
					posn: 300 147 0
					setScaler: Scaler 100 83 153 118
					init:
				)
				(receptTeller init: recept 410)
				(self setScript: from415Scr)
			)
		)
		(recept init: signal: (| (recept signal:) $4000))
		(plant init:)
		(carpet init:)
		(desk init:)
		(leftHall init:)
		(rightHall init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((< (gEgo x:) 35)
				(gGame handsOff:)
				(self setScript: restrictScr)
			)
			((and (> (gEgo x:) 275) (not local8))
				(gGame handsOff:)
				(self setScript: restrictScr)
			)
			((> (gEgo x:) 280)
				(self newRoom: 415)
			)
			((> (gEgo y:) 157)
				(self newRoom: 405)
			)
		)
	)

	(method (dispose)
		(gPqFlags set: 94)
		(super dispose:)
	)
)

(instance recept of Actor
	(properties
		noun 2
		approachX 160
		approachY 147
		approachDist 100
		x 133
		y 87
		view 410
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(cond
					((== gPrevRoomNum 415) 0)
					((not local0)
						(= local5 1)
						(if (not (gPqFlags test: 94))
							(gMessager say: noun theVerb 3 0) ; "Hello, I'm Detective John Carey, Homicide, LAPD. I'd like to talk to the person in charge here."
						else
							(gMessager say: noun theVerb 16 0) ; "Hello, Nora, do you remember me? I'm Detective Carey, LAPD. I'd like to look over Miss Parker's office another time."
						)
					)
					(else
						(= local7 0)
						(switch local1
							(0
								(gGame handsOff:)
								(++ local1)
								(gCurRoom setScript: lookUpCarScr)
							)
							(11
								(gGame handsOff:)
								(gCurRoom setScript: escortScr)
							)
							(else
								(gCurRoom setScript: infoScr)
							)
						)
					)
				)
			)
			((== theVerb 27) ; badge
				(gGame points: 1 59)
				(cond
					(local0
						(gMessager say: noun theVerb 28 0) ; "There is no need to show her your badge again."
					)
					(local5
						(= local0 1)
						(if (not (gPqFlags test: 94))
							(gGame handsOff:)
							(gCurRoom setScript: badgeScr 0 1)
						else
							(gGame handsOff:)
							(gCurRoom setScript: badgeScr 0 3)
						)
					)
					(else
						(= local0 1)
						(if (not (gPqFlags test: 94))
							(gGame handsOff:)
							(gCurRoom setScript: badgeScr 0 2)
						else
							(gGame handsOff:)
							(gCurRoom setScript: badgeScr 0 4)
						)
					)
				)
			)
			((== theVerb 52) ; notebook
				(cond
					((or (not local0) local7)
						(gMessager say: noun theVerb 6) ; "What have you learned that is pertinent to your investigation?"
					)
					((not local6)
						(= local6 1)
						(gGame handsOff:)
						(gCurRoom setScript: noteScr)
					)
					(else
						(gMessager say: noun theVerb 7) ; "There is no need to re record the information you've learned."
					)
				)
			)
			((== theVerb 33) ; folders
				(if (not local2)
					(++ local2)
					(gMessager say: noun theVerb 0 1) ; "Well, let's see... those are Luella's current cases, or I suppose, in layman terms, her clients."
				else
					(gMessager say: noun theVerb 0 2) ; "Detective, as I said before, those files contain the case information on Luella's current clients."
				)
			)
			((== theVerb 36) ; tape
				(if (not local3)
					(++ local3)
					(gMessager sayRange: noun theVerb 0 1 2) ; "Nora, I found this music tape on Luella's desk. Does it look familiar?"
				else
					(gMessager say: noun theVerb 0 3) ; "I told you, Detective, if you found it on her desk, it must be Luella's!"
				)
			)
			((== theVerb 22) ; handgun
				(cond
					((not local4)
						(gMessager say: noun theVerb 8 0) ; "Feelings of hostility and frustration have become part of our everyday lives. But what we have learned, through extensive research and counseling, is that violence does not solve our problems."
						(++ local4)
					)
					(((ScriptID 32 0) doit: noun theVerb 9 0 410) 0) ; ShootHandgun
				)
			)
			(
				(OneOf
					theVerb
					34 ; boneBaggie
					74 ; candyBar
					30 ; cigarette
					29 ; coins
					73 ; crimeSceneReport
					12 ; evidenceCase
					68 ; funeralMemo
					47 ; handcuffs
					14 ; hickmanStuff
					66 ; parkerID
					41 ; lighter
					45 ; matches
					18 ; mirror
					28 ; newspaper
					57 ; photo
					39 ; pills
					32 ; pretzels
					63 ; casePryBar
				)
				(if local0
					(gMessager say: noun theVerb 28 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((== theVerb 31) ; shoe
				(if (not local0)
					(gMessager say: noun theVerb 3 0) ; "Excuse me, what do you make of this shoe?"
				else
					(gMessager say: noun theVerb 28 0) ; "Nora, what is your opinion... could this be Luella's shoe?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance receptTeller of Teller
	(properties
		sayNoun 8
		verb 5
	)

	(method (showCases)
		(= local7 0)
		(super showCases: 22 (gEgo has: 22)) ; folders
	)
)

(instance restrictScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 160)
					(= register 20)
					(gMessager say: 2 3 10 1 self) ; "Excuse me... excuse me. That's a restricted area."
				else
					(= register -20)
					(gMessager say: 2 3 10 2 self) ; "Persons other than Social Service employees must be escorted back there."
				)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(+ (gEgo x:) register)
						(gEgo y:)
						self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance noteScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 0) init: self) ; NotebookOut
			)
			(1
				((ScriptID 39 1) init: self 9120) ; NotebookIn
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance badgeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo distanceTo: recept) (recept approachDist:))
					(gEgo setMotion: PolyPath 160 147 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo view: 9126 setCycle: 0 setLoop: 3 cel: 0)
				(= cycles 8)
			)
			(2
				(gEgo cel: 1)
				(= cycles 8)
			)
			(3
				(switch register
					(1
						(gMessager say: 2 27 13 1 self) ; "I'm with Major Crimes. I'd like to speak with the person in charge please."
					)
					(2
						(gMessager say: 2 27 11 1 self) ; "Hello, I'm Detective John Carey, Homicide, LAPD. I'd like to speak to the person in charge, please."
					)
					(3
						(gMessager say: 2 27 15 1 self) ; "Hello, I'm Detective Carey, Homicide. I'd like to look over Luella Parker's office, please."
					)
					(4
						(gMessager say: 2 27 12 1 self) ; "Hello, I'm Detective Carey, LAPD Homicide. I'd like to look over Luella Parker's office please."
					)
				)
			)
			(4
				(gEgo cel: 0)
				(= cycles 8)
			)
			(5
				(gEgo normalize: 9120)
				(= cycles 2)
			)
			(6
				(switch register
					(1
						(gMessager say: 2 27 13 2 self) ; "Our manager is out of the office for the week, detective. I'm Nora Hayes, may I be of assistance?"
					)
					(2
						(gMessager say: 2 27 11 2 self) ; "I'm sorry, detective, our manager is out for the week. I'm Nora Hayes, may I help you?"
					)
					(3
						(gMessager say: 2 27 15 2 self) ; "Yes, I remember you Detective. Of course."
					)
					(4
						(gMessager say: 2 27 12 2 self) ; "Well, yes of course, Detective. I remember you."
					)
				)
			)
			(7
				(if (< register 3)
					(gGame handsOn:)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(8
				(self setScript: leaveScr 0 1)
			)
		)
	)
)

(instance infoScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 2 5 local1 self)
			)
			(1
				(gMessager say: 2 2 5 (++ local1) self)
			)
			(2
				(++ local1)
				(self dispose:)
			)
		)
	)
)

(instance lookUpCarScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 2 4 1 self) ; "Nora, a car registered to Social Services has wound up in impound. Its license number is County 2BSY669. Can you tell me whom its assigned to please."
			)
			(1
				(gMessager say: 2 2 4 2 self) ; "Yes, Detective, just let me look that up."
			)
			(2
				(recept code: 0 setLoop: 0 cel: 0)
				(= cycles 5)
			)
			(3
				(= seconds 3)
			)
			(4
				(recept setLoop: 1 code: headCode)
				(= cycles 5)
			)
			(5
				(gMessager say: 2 2 4 3 self) ; "Why, that car is assigned to one of our social workers, a Miss Luella Parker."
			)
			(6
				(gPqFlags set: 140)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance escortScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 2 5 11 self) ; "Nora, I'd like to look over Luella's office, please."
			)
			(1
				(gMessager say: 2 2 5 12 self) ; "Why of course, Detective."
			)
			(2
				(self setScript: leaveScr 0 2)
			)
		)
	)
)

(instance leaveScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(recept code: 0 view: 413 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(recept setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(if (== register 1)
					(gMessager say: 2 27 12 3 self) ; "Please follow me, and I'll escort you to her office."
				else
					(gMessager say: 2 2 5 13 self) ; "If you'll follow me, I'll escort you back to her office."
				)
			)
			(3
				(recept
					view: 414
					setLoop: 0
					x: (+ (recept x:) 3)
					y: (+ (recept y:) 42)
					xStep: 4
					setCycle: Walk
				)
				(recept setMotion: MoveTo 240 (recept y:) self)
			)
			(4
				(recept setMotion: MoveTo 304 (recept y:) self)
				(gEgo setMotion: PolyPath 300 140 self)
			)
			(5 0)
			(6
				(gPqFlags set: 95)
				(gCurRoom newRoom: 415)
			)
		)
	)
)

(instance from405Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(recept setCycle: End self)
			)
			(2
				(gMessager say: 2 0 1 0 self) ; "May I help you, sir?"
			)
			(3
				(gGame handsOn:)
				(recept setLoop: 1 code: headCode)
				(self dispose:)
			)
		)
	)
)

(instance from415Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 160 147 self)
			)
			(2
				(recept setCycle: End self)
			)
			(3
				(gMessager say: 2 0 2 0 self) ; "Can I help you with anything, Detective?"
			)
			(4
				(gGame handsOn:)
				(recept setLoop: 1 code: headCode)
				(self dispose:)
			)
		)
	)
)

(instance headCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(cond
			(
				(and
					(>
						(= temp0
							(GetAngle
								(param1 x:)
								(+ (param1 y:) 50)
								(gEgo x:)
								(gEgo y:)
							)
						)
						80
					)
					(< temp0 92)
				)
				(param1 cel: 4)
			)
			((and (> temp0 91) (< temp0 105))
				(param1 cel: 3)
			)
			((and (> temp0 104) (< temp0 254))
				(param1 cel: 2)
			)
			((and (> temp0 253) (< temp0 270))
				(param1 cel: 1)
			)
			((and (> temp0 269) (< temp0 280))
				(param1 cel: 0)
			)
		)
	)
)

(instance plant of Feature
	(properties
		noun 5
		x 85
		y 48
	)

	(method (init)
		(self createPoly: 97 23 114 42 109 48 87 48 80 40 81 32 88 22)
		(super init: &rest)
	)
)

(instance carpet of Feature
	(properties
		noun 3
		sightAngle 180
		x 160
		y 113
	)

	(method (init)
		(self
			createPoly: 38 123 55 123 81 113 228 113 259 124 273 124 273 148 38 148
		)
		(super init: &rest)
	)
)

(instance desk of Feature
	(properties
		noun 4
		x 160
		y 114
	)

	(method (init)
		(self createPoly: 94 85 217 85 217 138 94 138)
		(super init: &rest)
	)
)

(instance leftHall of Feature
	(properties
		noun 6
		nsRight 48
		nsBottom 148
		y 74
	)
)

(instance rightHall of Feature
	(properties
		noun 7
		nsLeft 261
		nsRight 303
		nsBottom 148
		x 303
		y 74
	)
)

