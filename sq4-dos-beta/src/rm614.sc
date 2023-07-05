;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 614)
(include sci.sh)
(use Main)
(use ulence)
(use SQRoom)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	rm614 0
)

(local
	local0
)

(instance rm614 of SQRoom
	(properties
		picture 614
		south 611
		west 613
	)

	(method (init)
		(ulence roomVer: 11491)
		(switch gPrevRoomNum
			(611
				(cond
					((> (gEgo x:) 240)
						(gEgo x: (Random 202 302))
					)
					((> (gEgo x:) 195)
						(gEgo x: (Random 85 201))
					)
					(else
						(gEgo x: (Random 20 84))
					)
				)
			)
			(else
				(gEgo x: 24 y: 181)
			)
		)
		(gEgo init: ignoreActors: 1 illegalBits: 0)
		(super init:)
		(self
			setFeatures: sign1 sign2 gate building
			setRegions: 706 ; ulence
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 317 189 317 152 266 161 206 161 179 153 77 154 75 161 0 161
					yourself:
				)
		)
		(if (and (not (Random 0 3)) (== (ulence status:) 1))
			(ulence status: 2)
			(Load rsVIEW 634)
			(Load rsVIEW 635)
			(Load rsSOUND 50)
		)
	)

	(method (doit)
		(if
			(and
				(== (ulence status:) 4)
				(< ((ScriptID 706 2) distanceTo: gEgo) 15) ; theBiker
			)
			(HandsOff)
			(ulence status: 6)
			(gEgo setScript: 0)
			(ulence deathLoop: 0)
			(self setScript: (ScriptID 706 4)) ; theDeathScript
		)
		(cond
			(script 0)
			(
				(and
					(== (ulence status:) 2)
					(gEgo inRect: 20 171 46 182)
					local0
				)
				(HandsOff)
				(ulence status: 3)
				((ScriptID 706 2) ; theBiker
					init:
					view: 634
					hide:
					posn: 308 217
					setScript: bikerScript
				)
				(= local0 0)
				(gEgo setScript: (ScriptID 706 5)) ; theDodgeR
			)
		)
		(super doit: &rest)
		(if (> (gEgo x:) 60)
			(= local0 1)
		)
	)
)

(instance bikerScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLongSong
					vol: 5
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 3)
			)
			(1
				((ScriptID 706 2) ; theBiker
					show:
					setLoop: 7
					setMotion: MoveTo 246 (- (gEgo y:) 5) self
				)
			)
			(2
				(ulence status: 4)
				(HandsOn)
				((ScriptID 706 2) ; theBiker
					setLoop: 1
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo -51 (- (gEgo y:) 5) self
				)
			)
			(3
				(gLongSong fade:)
				((ScriptID 706 2) hide:) ; theBiker
				(= seconds 3)
			)
			(4
				(if (== (ulence status:) 5)
					(ulence status: 1)
					(proc706_1)
					(HandsOn)
					(gEgo setScript: 0)
				else
					(EgoDead 614 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance building of Feature
	(properties
		x 155
		y 84
		nsTop 7
		nsBottom 161
		nsRight 311
		description {building}
		sightAngle 45
		onMeCheck 2
		lookStr {Droids-B-Us building.}
	)
)

(instance gate of Feature
	(properties
		x 125
		y 115
		nsTop 76
		nsLeft 60
		nsBottom 154
		nsRight 191
		description {gate}
		sightAngle 45
		onMeCheck 8
		lookStr {*** The gate is down, the store is CLOSED}
	)
)

(instance sign1 of Feature
	(properties
		x 125
		y 59
		nsTop 45
		nsLeft 37
		nsBottom 73
		nsRight 214
		description {sign1}
		sightAngle 45
		onMeCheck 16
		lookStr {For all of your droid-related needs see us - when we're open!}
	)
)

(instance sign2 of Feature
	(properties
		x 126
		y 130
		nsTop 122
		nsLeft 108
		nsBottom 138
		nsRight 145
		description {sign2}
		sightAngle 45
		onMeCheck 4
		lookStr {The sign indicates that this establishment is not open for business.}
	)
)

