;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7920)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SoundManager)
(use n132)
(use n1111)
(use VMDMovie)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	octoMorph 0
)

(local
	local0
)

(instance octoMorph of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(proc132_0)
		(switch gPrevRoomNum
			(7909 ; octoSubwayInsideCar
				(self
					addPicObj:
						faceBowls
						faceBlackBoardS
						faceSubway
						faceBlackBoardN
						faceBowls
				)
			)
			(7921 ; ocMorphBBNorth
				(self
					addPicObj:
						faceBlackBoardN
						faceBowls
						faceBlackBoardS
						faceSubway
						faceBlackBoardN
				)
			)
			(7922 ; ocMorphBBSouth
				(self
					addPicObj:
						faceBlackBoardS
						faceSubway
						faceBlackBoardN
						faceBowls
						faceBlackBoardS
				)
			)
			(7923 ; ocMorphGateNW
				(self
					addPicObj:
						faceSubway
						faceBlackBoardN
						faceBowls
						faceBlackBoardS
						faceSubway
				)
			)
			(7924 ; ocMorphGateSW
				(self
					addPicObj:
						faceSubway
						faceBlackBoardN
						faceBowls
						faceBlackBoardS
						faceSubway
				)
			)
			(else
				(self
					addPicObj:
						faceBowls
						faceBlackBoardS
						faceSubway
						faceBlackBoardN
						faceBowls
				)
			)
		)
	)

	(method (dispose)
		(proc132_1)
		(super dispose: &rest)
	)
)

(instance faceBlackBoardN of CameraAngle
	(properties
		picture 7952
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (== (proc70_9 16) 7921)
			(biotLaser init: global117)
		)
		(exitToBBNorth init:)
		(super init: &rest)
		(if (proc1111_24 188)
			(octoLeaves play:)
			(SetFlag 188)
		)
	)
)

(instance faceBowls of CameraAngle
	(properties
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(cond
			((proc1111_24 189)
				(= picture 7951)
				(gCurRoom drawPic: 7951)
				(gCurRoom setScript: sOctoStealsCrunchie)
			)
			((or (== (proc70_9 89) -1) (== (proc70_9 90) -1))
				(morph1Eating init: global117)
				(morph2Eating init: global117)
				(morph3Eating init: global117)
				(= picture 7951)
			)
			(else
				(= picture 7959)
				(morph1Eating init: global117)
				(morph2Eating init: global117)
				(emptyBowl init:)
			)
		)
		(super init: &rest)
	)
)

(instance faceBlackBoardS of CameraAngle
	(properties
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToBBSouth init:)
		(if (and (!= (proc70_9 89) -1) (!= (proc70_9 90) -1))
			(cond
				((proc1111_24 196)
					(= picture 7961)
					(gCurRoom setScript: sAngryMorph)
				)
				((proc1111_24 197)
					(= picture 7963)
					(gCurRoom setScript: sDepressedMorph)
				)
				(else
					(= picture 7962)
				)
			)
		else
			(= picture 7954)
		)
		(if (== (proc70_9 109) 7922)
			(catCard init: global117)
		)
		(super init: &rest)
	)

	(method (dispose)
		(cond
			((proc1111_24 196)
				(SetFlag 196)
			)
			((proc1111_24 197)
				(SetFlag 197)
				(proc1111_6)
				(= global105 0)
				(gCurRoom setScript:)
			)
		)
		(super dispose:)
	)
)

(instance faceSubway of CameraAngle
	(properties
		picture 7953
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToGateNW init:)
		(gCurRoom exitNW: exitToGateNW)
		(exitToGateSW init:)
		(gCurRoom exitNE: exitToGateSW)
		(exitToSubway init:)
		(gCurRoom exitN: exitToSubway)
		(littleCrunchie init: global117)
		(super init:)
	)
)

(instance exitToGateNW of ExitFeature
	(properties
		nsLeft 347
		nsTop 136
		nsRight 543
		nsBottom 201
		nextRoom 7923
	)
)

(instance exitToGateSW of ExitFeature
	(properties
		nsLeft 54
		nsTop 134
		nsRight 232
		nsBottom 196
		nextRoom 7924
	)
)

(instance exitToBBNorth of Feature
	(properties
		nsLeft 191
		nsTop 157
		nsRight 365
		nsBottom 258
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7921) ; ocMorphBBNorth
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSubway of ExitFeature
	(properties
		nsLeft 240
		nsTop 93
		nsRight 338
		nsBottom 186
		nextRoom 7909
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(ClearFlag 197)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToBBSouth of Feature
	(properties
		nsLeft 223
		nsTop 92
		nsRight 397
		nsBottom 195
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (and (!= (proc70_9 89) -1) (!= (proc70_9 90) -1))
					(if (proc1111_24 196)
						(gCurRoom setScript: sGuardMorph1)
					else
						(gCurRoom setScript: sGuardMorph2)
					)
				else
					(gCurRoom newRoom: 7922) ; ocMorphBBSouth
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sOctoStealsCrunchie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 189)
				(= seconds 1)
			)
			(1
				(octoStealsCrunchie play:)
				(= cycles 1)
			)
			(2
				(morph1Eating init: global117)
				(morph2Eating init: global117)
				(emptyBowl init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveCrunchie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom drawPic: 7960)
				(= seconds 2)
			)
			(1
				(morphReturns play:)
				(= cycles 1)
			)
			(2
				(gCurRoom picture: 7951 drawPic: 7951)
				(morph3Eating init: global117)
				(gGame handsOn:)
				(SoundManager playMusic: 0 -1 7000)
				(self dispose:)
			)
		)
	)
)

(instance sDepressedMorph of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_7 7915 355 235 global161 0 -1 1 self)
			)
			(1
				(= global161 0)
				(= state -1)
				(= seconds (Random 4 8))
			)
		)
	)
)

(instance sAngryMorph of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(angryMorph play:)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGuardMorph1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (Random 1 3))
				(= cycles 1)
			)
			(1
				(guardMorph1 play:)
				(= cycles 1)
			)
			(2
				(if (-- local0)
					(= state 0)
				)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGuardMorph2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (proc1111_24 197)
					(SetFlag 197)
					(sDepressedMorph dispose:)
					(proc1111_6)
					(= global105 0)
					(transitionMorph play:)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(1
				(guardMorph2 play:)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance morph1Eating of Prop
	(properties
		x 34
		y 113
		view 7914
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 16 setCycle: Fwd)
	)
)

(instance morph2Eating of Prop
	(properties
		x 258
		y 130
		view 7914
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 20 setCycle: Fwd)
	)
)

(instance morph3Eating of Prop
	(properties
		x 406
		y 129
		view 7914
		loop 2
	)

	(method (init)
		(if (or (== (proc70_9 89) -1) (== (proc70_9 90) -1))
			(super init: &rest)
			(self cycleSpeed: 12 setCycle: Fwd)
		)
	)
)

(instance emptyBowl of Feature
	(properties
		nsLeft 453
		nsTop 173
		nsRight 549
		nsBottom 218
	)

	(method (init)
		(= plane global116)
		(super init: &rest)
		(self setHotspot: 82)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(82
				(proc70_3)
				(gCurRoom setScript: sGiveCrunchie)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance catCard of View
	(properties
		x 267
		y 213
		view 7913
		cel 1
	)

	(method (init)
		(= priority 255)
		(self ignoreActors: 1)
		(super init: &rest)
	)
)

(instance biotLaser of View
	(properties
		x 208
		y 171
		view 7913
		cel 3
	)
)

(instance littleCrunchie of View
	(properties
		x 281
		y 169
		view 7913
		loop 2
	)

	(method (init)
		(if (or (== (proc70_9 89) 7909) (== (proc70_9 90) 7909))
			(super init: global117)
		)
	)
)

(instance octoLeaves of VMDMovie
	(properties
		movieName 7912
		x 196
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance octoStealsCrunchie of VMDMovie
	(properties
		movieName 7910
		begPic 7951
		endPic 7959
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance morphReturns of VMDMovie
	(properties
		movieName 7911
		begPic 7960
		endPic 7951
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance angryMorph of VMDMovie
	(properties
		movieName 7913
		x 206
		y 199
		begPic 7961
		endPic 7961
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance guardMorph1 of VMDMovie
	(properties
		movieName 7914
		x 206
		y 200
		begPic 7961
		endPic 7961
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance transitionMorph of VMDMovie
	(properties
		movieName 7916
		x 254
		y 196
		begPic 7963
		endPic 7962
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

(instance guardMorph2 of VMDMovie
	(properties
		movieName 7917
		x 206
		y 196
		begPic 7962
		endPic 7962
	)

	(method (play)
		(= plane global116)
		(super play: &rest)
	)
)

