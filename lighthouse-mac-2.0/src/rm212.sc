;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 212)
(include sci.sh)
(use Main)
(use LightRoom)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm212 0
)

(local
	local0
)

(instance rm212 of LightRoom
	(properties
		picture 212
	)

	(method (init)
		(if (OneOf (gMySoundFX number:) 2030 2032)
			(gMySoundFX setVol: 100)
		else
			(gMySoundFX stop:)
		)
		(if (IsFlag 229)
			(Load rsAUDIO 2030)
			(gMySoundFX number: 2030 play: setLoop: -1 setVol: 80)
		)
		(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
			((ScriptID 9 3) dispose:) ; PlCompass
		)
		(Load rsAUDIO 455 2023)
		(if (not (IsFlag 105))
			(gBackMusic number: 455 loop: -1 play:)
		else
			(gBackMusic number: 2011 setVol: 50 setLoop: -1 play:)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 225)
			(self changeScene: 213)
		else
			(self changeScene: 212)
		)
		(if (== gPrevRoomNum 210)
			(doorSound play:)
		)
		(if (not (OneOf gPrevRoomNum 700 225 210))
			(hatchSlam play:)
		)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 225)
			(gMySoundFX fade:)
		)
		(if (== newRoomNumber 210)
			(gBackMusic fade:)
		)
		(switch newRoomNumber
			(700
				(= global224 2)
				(= global225 700)
				(gGame getDisc: global224)
				(super newRoom: newRoomNumber)
			)
			(480
				(= global224 2)
				(= global225 480)
				(gGame getDisc: global224)
				(super newRoom: global225)
			)
			(810
				(= global224 1)
				(= global225 810)
				(gGame getDisc: global224)
				(super newRoom: global225)
			)
			(600
				(= global224 2)
				(= global225 600)
				(gGame getDisc: global224)
				(super newRoom: global225)
			)
			(else
				(super newRoom: newRoomNumber)
			)
		)
	)

	(method (changeScene param1)
		(gCast eachElementDo: #dispose)
		(if (gFeatures contains: downLeft)
			(downLeft dispose:)
		)
		(if (gFeatures contains: leftForward)
			(leftForward dispose:)
		)
		(if (gFeatures contains: upRight)
			(upRight dispose:)
		)
		(super changeScene: param1 &rest)
		(switch param1
			(212
				((ScriptID 1 2) newPic: 213) ; exitBack
				((ScriptID 1 1) newRoom: 225) ; exitForward
				((ScriptID 1 5) newPic: 215) ; exitDown
				(leftForward init: resetProps: newPic: 214)
				(if (gCast contains: runningEngine)
					(runningEngine dispose:)
				)
				(if (gCast contains: openDoor)
					(openDoor dispose:)
				)
				(if (gCast contains: closedDoor)
					(closedDoor dispose:)
				)
				(if (gCast contains: engineLever)
					(engineLever dispose:)
				)
			)
			(213
				((ScriptID 1 2) newPic: 212) ; exitBack
				(upRight
					init:
					nsLeft: 311
					nsTop: 0
					nsRight: 495
					nsBottom: 114
					newPic: 214
				)
				(doorCrank init:)
				((ScriptID 1 5) newPic: 215) ; exitDown
				(closedDoor init:)
				(engineLever init:)
				(if (and (IsFlag 110) local0)
					(if (IsFlag 229)
						(runningEngine init: setCycle: Fwd)
					)
					((ScriptID 1 1) newRoom: 210) ; exitForward
				)
			)
			(214
				(if (gCast contains: runningEngine)
					(runningEngine dispose:)
				)
				(if (gCast contains: closedDoor)
					(closedDoor dispose:)
				)
				(if (gCast contains: engineLever)
					(engineLever dispose:)
				)
				(switch global226
					(3
						((ScriptID 1 6) init: exitCode: outTo600) ; exitUp
					)
					(2
						(if (not (IsFlag 204))
							((ScriptID 1 6) init: exitCode: outTo480) ; exitUp
						)
					)
					(1
						((ScriptID 1 6) init: exitCode: outTo810) ; exitUp
					)
				)
				(downLeft init: newPic: 213)
				((ScriptID 1 5) newPic: 212 arrowStyle: 10) ; exitDown
			)
			(215
				(if (gCast contains: runningEngine)
					(runningEngine dispose:)
				)
				(if (gCast contains: closedDoor)
					(closedDoor dispose:)
				)
				(if local0
					(openDoor init:)
				)
				(downLeft
					init:
					newPic: 213
					nsLeft: 3
					nsTop: 151
					nsRight: 147
					nsBottom: 287
				)
				((ScriptID 1 5) ; exitDown
					newRoom: 700
					nsLeft: 102
					nsTop: 102
					nsRight: 281
					nsBottom: 229
				)
				((ScriptID 1 6) ; exitUp
					newPic: 212
					arrowStyle: 7
					nsLeft: 245
					nsTop: 4
					nsRight: 495
					nsBottom: 159
				)
			)
		)
	)
)

(instance openDoor of View
	(properties
		x -2
		y 300
		view 2214
	)
)

(instance runningEngine of Prop
	(properties
		x 254
		y 246
		view 2207
	)
)

(instance engineLever of View
	(properties
		x 312
		y 264
		view 2207
		loop 2
	)

	(method (init)
		(if (IsFlag 345)
			(= cel 0)
		else
			(= cel 1)
		)
		(super init: &rest)
		(self setPri: 298)
	)
)

(instance closedDoor of Prop
	(properties
		x 147
		y 299
		view 3206
	)

	(method (init)
		(if (IsFlag 229)
			(= view 3206)
			(if local0
				(= cel 11)
			else
				(= cel 0)
			)
		else
			(= view 2208)
			(if local0
				(= cel 12)
			else
				(= cel 0)
			)
		)
		(super init: &rest)
	)
)

(instance doorCrank of Prop
	(properties
		x 51
		y 299
		view 2208
		loop 1
	)

	(method (cue)
		(gGame handsOn:)
		(if (and (!= cel 0) (IsFlag 229))
			(runningEngine init: setPri: 300 setCycle: Fwd)
		)
	)

	(method (init)
		(if local0
			(= cel 9)
		else
			(= cel 0)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (IsFlag 110)) ; Do
			(gGame handsOff:)
			(if (== cel 0)
				(= local0 1)
				((ScriptID 1 1) newRoom: 210) ; exitForward
				(self setCycle: End self)
				(closedDoor setCycle: End)
				(doorSound play:)
			else
				(= local0 0)
				(if (gCast contains: runningEngine)
					(runningEngine dispose:)
				)
				((ScriptID 1 1) dispose:) ; exitForward
				(self setCycle: Beg self)
				(closedDoor setCycle: Beg)
				(doorSound play:)
			)
		)
	)
)

(instance leftForward of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 8)
		(= nsTop (= nsLeft 0))
		(= nsRight 140)
		(= nsBottom 299)
		(super init: &rest)
	)
)

(instance downLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 9)
		(= nsLeft 35)
		(= nsRight 174)
		(= nsTop 117)
		(= nsBottom 291)
		(super init: &rest)
	)
)

(instance upRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 7)
		(= nsLeft 311)
		(= nsTop 0)
		(= nsRight 495)
		(= nsBottom 114)
		(super init: &rest)
	)
)

(instance doorSound of Sound
	(properties
		flags 1
		number 2023
	)
)

(instance hatchSlam of Sound
	(properties
		flags 1
		number 2026
	)
)

(instance outTo600 of Code
	(properties)

	(method (doit)
		(gCurRoom setScript: goTo600)
	)
)

(instance goTo600 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hatchOpen play: self)
			)
			(1
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance outTo480 of Code
	(properties)

	(method (doit)
		(gCurRoom setScript: goto480)
	)
)

(instance goto480 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hatchOpen play: self)
			)
			(1
				(gCurRoom newRoom: 480)
			)
		)
	)
)

(instance outTo810 of Code
	(properties)

	(method (doit)
		(gCurRoom setScript: goto810)
	)
)

(instance goto810 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hatchOpen play: self)
			)
			(1
				(gCurRoom newRoom: 810)
			)
		)
	)
)

(instance hatchOpen of Sound
	(properties
		flags 1
		number 2026
	)
)

