;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Feature)
(use Game)
(use System)

(public
	exitForward 1
	exitBack 2
	exitLeft 3
	exitRight 4
	exitDown 5
	exitUp 6
	exitBackUp 7
)

(class LightRoom of Room
	(properties
		scene 0
		compassDir 17
	)

	(method (init)
		(super init: &rest)
		(if (and (not (OneOf gCurRoomNum 5 20)) (not (IsFlag 9)))
			(gGame handsOn:)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (not (OneOf newRoomNumber 5 20)) (not (IsFlag 9)))
			(gGame handsOff:)
		)
		(ClearFlag 9)
		(global206 release:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (changeScene param1 param2 &tmp temp0)
		(DoRobot)
		(if (< argc 2)
			(= compassDir 17)
		else
			(= compassDir param2)
		)
		(if (and (< argc 2) (gGame compassFace:))
			(PrintDebug {Please provide a direction for this pic angle.\n})
		)
		(= scene param1)
		(gCurRoom drawPic: scene 0 1)
		(gGame normalizeCursor:)
		(if (and (gGame compassFace:) (>= argc 2))
			((gGame compassFace:) setLoop: param2 setCel: 0)
		)
		(PrintDebug {})
		(PrintDebug {SCENE:______%d} scene)
		(if global105
			(global105 release:)
		)
		(= global106 0)
	)

	(method (fade param1 param2 param3 &tmp temp0 temp1)
		(if (not argc)
			(PrintDebug {You didn't specify which way to fade.\n})
			(return)
		)
		(= temp1 16)
		(if (== param1 1)
			(for ((= temp0 1)) (< temp0 400) ((+= temp0 temp1))
				(if (== param2 1)
					(Palette 2 0 255 (/ temp0 4)) ; PalIntensity
				else
					(Palette 2 0 200 (/ temp0 4)) ; PalIntensity
				)
				(FrameOut)
			)
			(if (== param2 1)
				(Palette 2 0 255 100) ; PalIntensity
			else
				(Palette 2 0 200 100) ; PalIntensity
			)
			(FrameOut)
		)
		(if (== param1 2)
			(for ((= temp0 400)) (> temp0 0) ((-= temp0 temp1))
				(if (== param2 1)
					(Palette 2 0 255 (/ temp0 4)) ; PalIntensity
				else
					(Palette 2 0 200 (/ temp0 4)) ; PalIntensity
				)
				(FrameOut)
			)
			(if (== param2 1)
				(Palette 2 0 255 0) ; PalIntensity
			else
				(Palette 2 0 200 0) ; PalIntensity
			)
			(FrameOut)
		)
		(if (> argc 2)
			(if (param3 respondsTo: #cue)
				(param3 cue:)
			else
				(PrintDebug {Your caller has no cue method.\n})
			)
		)
	)

	(method (doVerb)
		(return 0)
	)

	(method (dispose &tmp temp0)
		(if global105
			(for ((= temp0 0)) (< temp0 (global105 size:)) ((++ temp0))
				(if (gFeatures contains: (global105 at: temp0))
					(gFeatures delete: (global105 at: temp0))
				)
			)
			(global105 eachElementDo: #dispose)
			(global105 dispose:)
			(= global105 0)
			(= global106 0)
		)
		(DoRobot)
		(super dispose: &rest)
	)
)

(instance exitLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 1)
		(= nsLeft 0)
		(= nsTop 90)
		(= nsRight 60)
		(= nsBottom 210)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 1)
		(= nsLeft 0)
		(= nsTop 90)
		(= nsRight 60)
		(= nsBottom 210)
		(PrintDebug {___LEFT_____%d} (self curPic:))
	)
)

(instance exitRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(= nsLeft 440)
		(= nsTop 90)
		(= nsRight 500)
		(= nsBottom 210)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 0)
		(= nsLeft 440)
		(= nsTop 90)
		(= nsRight 500)
		(= nsBottom 210)
		(PrintDebug {___RIGHT:___%d} (self curPic:))
	)
)

(instance exitForward of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(= nsLeft 170)
		(= nsTop 100)
		(= nsRight 330)
		(= nsBottom 175)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 3)
		(= nsLeft 170)
		(= nsTop 100)
		(= nsRight 330)
		(= nsBottom 175)
		(PrintDebug {___FORWARD: %d} (self curPic:))
	)
)

(instance exitBack of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 4)
		(= nsLeft 170)
		(= nsTop 250)
		(= nsRight 330)
		(= nsBottom 300)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 4)
		(= nsLeft 170)
		(= nsTop 250)
		(= nsRight 330)
		(= nsBottom 300)
		(PrintDebug {___BACK:____%d} (self curPic:))
	)
)

(instance exitDown of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 6)
		(= nsLeft 170)
		(= nsTop 175)
		(= nsRight 330)
		(= nsBottom 250)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 6)
		(= nsLeft 170)
		(= nsTop 175)
		(= nsRight 330)
		(= nsBottom 250)
		(PrintDebug {___DOWN:____%d} (self curPic:))
	)
)

(instance exitUp of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 5)
		(= nsLeft 170)
		(= nsTop 0)
		(= nsRight 330)
		(= nsBottom 100)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 5)
		(= nsLeft 170)
		(= nsTop 0)
		(= nsRight 330)
		(= nsBottom 100)
		(PrintDebug {___UP:______%d} (self curPic:))
	)
)

(instance exitBackUp of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 2)
		(= nsLeft 170)
		(= nsTop 250)
		(= nsRight 330)
		(= nsBottom 300)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 2)
		(= nsLeft 170)
		(= nsTop 250)
		(= nsRight 330)
		(= nsBottom 300)
		(PrintDebug { BACK UP:___%d} (self curPic:))
	)
)

