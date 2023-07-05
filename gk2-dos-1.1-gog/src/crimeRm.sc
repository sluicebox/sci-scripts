;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Cursor)
(use Actor)
(use System)

(public
	crimeRm 0
)

(local
	local0 = 1
)

(instance crimeRm of ExitRoom ; "Crime Scene Street"
	(properties
		noun 10
		picture 4701
		south 4102 ; rm4102
	)

	(method (init)
		(gEgo
			posn: 189 323
			heading: 45
			normalize:
			setScaler: Scaler 74 52 325 267
			init:
		)
		(super init: &rest)
		(if (not (IsFlag 516))
			(fLeber init:)
			(fLookieLoos init:)
			(fBodyArea init:)
			(fNewsCrew init:)
			(pLeberGroup init: setScript: (FidgetScript new:))
			(if (< (MemoryInfo 0) 1000)
				(pLookieLoos init:)
			else
				(pLookieLoos init: setScript: (FidgetScript new:))
			)
			(pNewsCrew init: setScript: (FidgetScript new:))
			(if (not (IsFlag 532))
				(SetFlag 532)
				(gGame changeScore: 930)
				(gCurRoom setScript: sCrimeScene)
			)
		)
		(if (> (MemoryInfo 0) 600)
			(Lock 140 470 1) ; WAVE
			(gGk2Sound setLoop: -1 number: 470 play:)
			(gSoundManager play: 0 471 472 473 474)
			(= local0 1)
		else
			(= local0 0)
		)
		(gGame handsOn:)
	)

	(method (cue)
		(= local0 0)
		(gSoundManager stop:)
		(self newRoom: 4102)
	)

	(method (newRoom newRoomNumber)
		(Lock 140 470 0) ; WAVE
		(if (and local0 (== newRoomNumber 4102))
			(gGk2Sound fade: 0 10 10 1)
			(gSoundManager fade: 0 10 10 1 self)
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance sCrimeScene of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 20)
			)
			(1
				(if (IsFlag 24)
					(gMessager say: 1 0 2 0 self 470) ; "(ENTER CRIME SCENE, ALREADY KNEW ABOUT NEW MURDER)Guess I've figured out where last night's killin' took place."
				else
					(gMessager say: 1 0 1 0 self 470) ; "(CRIME SCENE STREET, SHOCKED)Looks like there was another wolf killin' last night!"
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pNewsCrew of Prop
	(properties
		sightAngle 360
		x 73
		y 294
		priority 30
		fixPriority 1
		view 23336
		signal 30753
	)

	(method (init)
		(super init: &rest)
		(GKHotCursor delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance pLookieLoos of Prop
	(properties
		sightAngle 360
		x 203
		y 228
		priority 29
		fixPriority 1
		view 24336
		signal 30753
	)

	(method (init)
		(super init: &rest)
		(GKHotCursor delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance pLeberGroup of Prop
	(properties
		sightAngle 360
		x 250
		y 292
		priority 30
		fixPriority 1
		view 25336
		cel 1
		signal 30753
	)

	(method (init)
		(super init: &rest)
		(GKHotCursor delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance fLookieLoos of Feature
	(properties
		sightAngle 360
		x 304
		y 220
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 203 153 223 153 230 167 243 165 290 169 290 151 319 146 329 151 346 145 391 157 405 183 402 234 397 280 370 296 344 279 324 278 320 261 287 261 287 228 203 228
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 12) ; "(PICKUP, TRY TO TALK TO PEDESTRIANS AT CRIME SCENE)I don't think they'd know much about it."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fNewsCrew of Feature
	(properties
		sightAngle 360
		x 136
		y 216
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 96 142 125 152 169 135 183 148 195 193 179 220 184 274 141 290 104 298 80 285 78 182
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 530)
					(gMessager say: 9 0 0 0 0 470) ; "(TRY TO TALK TO NEWS CREW AFTER NEWS CREW SCENE)I told Leber I wouldn't talk to the press anymore. Too bad. I coulda been another David Hasselhof."
				else
					(gMessager say: 7 62 0 0 0 470) ; "(LOOK AT NEWS CREW, SNEAKY ON LAST PART)Looks like a television news crew. Maybe they need some news."
				)
			)
			(41 ; invEvidenceReport
				(if (and (not (IsFlag 530)) (not (IsFlag 538)))
					(gGame handsOff:)
					(SetFlag 530)
					(SetFlag 27)
					(gSoundManager pauseAll: 1)
					(PlayScene 340)
				else
					(gMessager say: 9 0 0 0 0 470) ; "(TRY TO TALK TO NEWS CREW AFTER NEWS CREW SCENE)I told Leber I wouldn't talk to the press anymore. Too bad. I coulda been another David Hasselhof."
				)
			)
			(else
				(if (not (IsFlag 530))
					(gMessager say: 8 0 0 0 0 470) ; "(TRY TO SHOW SOMETHING OTHER THAN EVIDENCE REPORT TO NEWS CREW)I'm not sure the German public would be interested in that."
				else
					(gMessager say: 9 0 0 0 0 470) ; "(TRY TO TALK TO NEWS CREW AFTER NEWS CREW SCENE)I told Leber I wouldn't talk to the press anymore. Too bad. I coulda been another David Hasselhof."
				)
			)
		)
	)
)

(instance fBodyArea of Feature
	(properties
		noun 2
		sightAngle 360
		x 230
		y 242
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 200 261 260 261 260 224 200 224
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fLeber of Feature
	(properties
		sightAngle 360
		x 271
		y 205
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 253 144 290 144 290 267 253 267
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 530)
						(gMessager say: 6 0 0 0 0 470) ; "(LOOK AT LEBER AFTER NEWS CREW SCENE, PLEASED WITH HIMSELF)He's busy. I'll see him at the station."
					)
					((IsFlag 535)
						(gMessager say: 4 62 0 0 0 470) ; "(TRY TO TALK TO LEBER AFTER FIRST TIME)He's not listening."
					)
					((IsFlag 534)
						(SetFlag 536)
						(SetFlag 535)
						(gSoundManager pauseAll: 1)
						(PlayScene 338)
					)
					(else
						(SetFlag 534)
						(gMessager say: 3 62 0 0 0 470) ; "(CURIOUS)Isn't that the detective from the paper? Komissar Leber?"
					)
				)
			)
			(48 ; invGabeCards
				(cond
					((IsFlag 530)
						(gMessager say: 6 0 0 0 0 470) ; "(LOOK AT LEBER AFTER NEWS CREW SCENE, PLEASED WITH HIMSELF)He's busy. I'll see him at the station."
					)
					((IsFlag 536)
						(gMessager say: 4 62 0 0 0 470) ; "(TRY TO TALK TO LEBER AFTER FIRST TIME)He's not listening."
					)
					(else
						(SetFlag 535)
						(SetFlag 536)
						(gSoundManager pauseAll: 1)
						(PlayScene 338)
					)
				)
			)
			(41 ; invEvidenceReport
				(cond
					((IsFlag 530)
						(gMessager say: 6 0 0 0 0 470) ; "(LOOK AT LEBER AFTER NEWS CREW SCENE, PLEASED WITH HIMSELF)He's busy. I'll see him at the station."
					)
					((IsFlag 537)
						(gMessager say: 5 41 0 0 0 470) ; "(TRY TO SHOW LEBER EVIDENCE REPORT AFTER FIRST TIEM)He's just being real, real stubborn about that. I'll have to think of something else."
					)
					(else
						(SetFlag 537)
						(gSoundManager pauseAll: 1)
						(PlayScene 339)
					)
				)
			)
			(else
				(if (IsFlag 530)
					(gMessager say: 6 0 0 0 0 470) ; "(LOOK AT LEBER AFTER NEWS CREW SCENE, PLEASED WITH HIMSELF)He's busy. I'll see him at the station."
				else
					(gMessager say: 11 62 0 0 0 470) ; "(TRY TO SHOW SOMETHING OTHER THAN BUSINESS CARD OR EVIDENCE REPORT TO LEBER AT CRIME SCENE, WRY)I don't think Komissar Leber would be impressed with that."
				)
			)
		)
	)
)

