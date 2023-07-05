;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use Sound)
(use Motion)
(use System)

(public
	farmFldRm 0
)

(local
	local0
)

(instance farmFldRm of ExitRoom ; "Huber Farm Exterior"
	(properties
		noun 9
		picture 2201
	)

	(method (cue)
		(gCurRoom newRoom: local0)
	)

	(method (init)
		(if (gEgo has: 73) ; invPitcher
			(Palette 1 (= global249 201)) ; PalLoad
		else
			(Palette 1 (= global249 200)) ; PalLoad
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(200 ; MunichMapRm
				(gEgo posn: 255 272 heading: 225)
				(Lock 140 220 1) ; WAVE
				(gGk2Music number: 220 setLoop: -1 play:)
			)
			(210 ; farmIntRm
				(gEgo posn: 255 272 heading: 225)
				(Lock 140 220 1) ; WAVE
				(gGk2Music number: 220 setLoop: -1 play:)
			)
			(2213
				(gEgo
					posn: 50 264
					heading: 135
					normalize:
					setScaler: Scaler 35 25 285 252
					init:
				)
			)
			(2244
				(gEgo
					posn: 50 264
					heading: 135
					normalize:
					setScaler: Scaler 35 25 285 252
					init:
				)
			)
			(else
				(gEgo posn: 255 272 heading: 225)
				(Lock 140 220 1) ; WAVE
				(gGk2Music number: 220 setLoop: -1 play:)
			)
		)
		(if (and (!= gPrevRoomNum 2213) (!= gPrevRoomNum 2244))
			(gEgo normalize: setScaler: Scaler 40 24 290 262 init:)
		)
		(fEastExit init:)
		(fBarnWall init:)
		(fFarmBuilding init:)
		(fLadder init:)
		(fFrontDoor init:)
		(fCar init:)
		(gGame handsOn: 0)
	)
)

(instance fEastExit of ExitFeature
	(properties
		x 537
		y 300
		nextRoomNum 2202 ; rm2202
		exitDir 2
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (gEgo has: 73)) ; invPitcher
			(gGame handsOff:)
			(= global141 self)
			(= local0 2202)
			(if (== gPrevRoomNum 2213)
				(gEgo view: 471 cel: 0 loop: 0 setCycle: End gCurRoom)
			else
				(super handleEvent: event &rest)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 537 -1 539 260 404 332 621 334 615 -1)
	)
)

(instance fFrontDoor of ExitFeature
	(properties
		approachX 229
		approachY 253
		exitDir 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 214 256 214 192 248 192 248 256)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom setScript: fadeSoundScript 0 210)
			)
			(111 ; invPitcher
				(gMessager say: 24 62 0 1 0 220) ; "(PICKUP, TRY TO ENTER FARMHOUSE WHILE CARRYING CEMENT PAIL)I don't want to take this cement in there. It'd make a mess."
			)
			(else
				(gCurRoom setScript: fadeSoundScript 0 210)
			)
		)
	)
)

(instance fBarnWall of ExitFeature
	(properties
		nextRoomNum 2213 ; rm2213
		exitDir 6
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (gEgo has: 73)) ; invPitcher
			(gGame handsOff:)
			(= global141 self)
			(= local0 2213)
			(if (== gPrevRoomNum 2202)
				(gEgo view: 473 cel: 0 loop: 0 setCycle: End gCurRoom)
			else
				(super handleEvent: event &rest)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 98 247 98 168 0 151 0 264)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 62) (== theVerb 111)) ; Do, invPitcher
			(gCurRoom newRoom: 2213)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fFarmBuilding of GKFeature
	(properties
		noun 14
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 86 7 484 7 539 57 538 161 103 162)
	)
)

(instance fLadder of GKFeature
	(properties
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 456 268 471 268 467 172 450 174)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 15 62 0 1 0 220) ; "(LOOKING AT LADDER)I s'pose that's for tendin' those window boxes."
			)
			(111 ; invPitcher
				(gMessager say: 25 62 0 1 0 220) ; "(PICKUP, TRY TO CLICK ON CAR OR OTHER ITEMS WHILE CARRYING CEMENT PAIL)I don't want to use cement on THAT."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fCar of GKFeature
	(properties
		x 120
		y 240
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				118
				214
				169
				215
				183
				232
				185
				260
				161
				287
				89
				284
				79
				267
				82
				248
				102
				235
		)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(if (== (event message:) KEY_4)
				(= sightAngle 5)
			else
				(= sightAngle 360)
			)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 1 62 0 1 0 220) ; "(LOOK AT HUBER CAR)I was hoping for a Mercedes, but it'll have to do."
			)
			(52 ; invHuberKeys
				(gGame handsOff:)
				(gCurRoom setScript: fadeSoundScript 0 200)
			)
			(111 ; invPitcher
				(gMessager say: 25 62 0 1 0 220) ; "(PICKUP, TRY TO CLICK ON CAR OR OTHER ITEMS WHILE CARRYING CEMENT PAIL)I don't want to use cement on THAT."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carSound of Sound
	(properties
		number 221
	)
)

(instance fadeSoundScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock 140 220 0) ; WAVE
				(gGk2Music fade: 0 20 10 1 self)
			)
			(1
				(switch register
					(210
						(gCurRoom newRoom: 210) ; farmIntRm
					)
					(else
						(gCurRoom picture: -1 drawPic: -1)
						(gCast eachElementDo: #dispose)
						(= cycles 2)
					)
				)
			)
			(2
				(PlayScene 16 self -1)
			)
			(3
				(if (IsFlag 448)
					(self cue:)
				else
					(carSound play: self)
				)
			)
			(4
				(SetFlag 448)
				(gCurRoom newRoom: 200) ; MunichMapRm
			)
		)
	)
)

