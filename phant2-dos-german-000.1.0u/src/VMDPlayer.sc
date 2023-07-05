;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64910)
(include sci.sh)
(use Main)
(use Str)
(use WriteFeature)
(use TextField)

(class VMDPlayer of Obj
	(properties
		plane -1
		priority -1
		x 0
		y 0
		loop 0
		number -1
		dir 1
		firstFrame -1
		lastFrame -1
		buffSize 0
		palStart -1
		palEnd -1
		rgbBoost 0
		interval 0
		black 0
		putOptions 0
		hotSet 0
		muted 0
		eventOptions -1
	)

	(method (doubled param1)
		(if argc
			(if param1
				(|= putOptions $0001)
			else
				(&= putOptions $fffe)
			)
		)
		(return (& putOptions $0001))
	)

	(method (boostRGB param1)
		(if argc
			(if param1
				(|= putOptions $0010)
			else
				(&= putOptions $ffef)
			)
			(= rgbBoost param1)
		)
		(return (& putOptions $0010))
	)

	(method (setOptions param1)
		(while argc
			(-- argc)
			(|= putOptions [param1 argc])
		)
		(return putOptions)
	)

	(method (blackLines param1)
		(if argc
			(if param1
				(|= putOptions $0004)
				(if (not rgbBoost)
					(self boostRGB: 25)
				)
			else
				(&= putOptions $fffb)
			)
		)
		(return (& putOptions $0004))
	)

	(method (dropFrames param1)
		(if argc
			(if param1
				(|= putOptions $0002)
			else
				(&= putOptions $fffd)
			)
		)
		(return (& putOptions $0002))
	)

	(method (holdBlackFrame param1)
		(if argc
			(if param1
				(|= putOptions $0020)
			else
				(&= putOptions $ffdf)
			)
		)
		(return (& putOptions $0020))
	)

	(method (holdLastFrame param1)
		(if argc
			(if param1
				(|= putOptions $0040)
			else
				(&= putOptions $ffbf)
			)
		)
		(return (& putOptions $0040))
	)

	(method (stretch param1)
		(if argc
			(if param1
				(|= putOptions $0100)
			else
				(&= putOptions $feff)
			)
		)
		(return (& putOptions $0100))
	)

	(method (getFrame)
		(PlayVMD 26)
	)

	(method (init &tmp temp0)
		(if (self getStatus:)
			(self close:)
		)
		(= temp0 (Str new:))
		(temp0 format: {%d.vmd} number)
		(PlayVMD 0 (KArray 9 temp0) buffSize 2) ; Open, ArrayGetData
		(cond
			((!= plane -1)
				(PlayVMD 27 (and (!= priority -1) priority) plane) ; SetPlane
			)
			((!= priority -1)
				(PlayVMD 27 priority) ; SetPlane
			)
		)
		(temp0 dispose:)
		(if (and (!= palStart -1) (!= palEnd -1))
			(PlayVMD 23 palStart palEnd) ; RestrictPalette
		)
		(if (not rgbBoost)
			(PlayVMD 1 x y putOptions) ; Put
		else
			(PlayVMD
				1 ; Put
				x
				y
				putOptions
				rgbBoost
				(if (== palStart -1) 0 else palStart)
				(if (== palEnd -1) 255 else palEnd)
			)
		)
	)

	(method (setHotSet param1)
		(if argc
			(= hotSet param1)
		else
			(= hotSet 0)
		)
	)

	(method (play param1 &tmp temp0 temp1 temp2 temp3)
		(= temp2 0)
		(if (not (self getStatus:))
			(proc64986_0 {Error: Movie not open.})
		else
			(while (not temp2)
				(if (== eventOptions -1)
					(= temp0 7)
				else
					(= temp0 eventOptions)
				)
				(= temp1 lastFrame)
				(if hotSet
					(+= temp0 8)
				)
				(if lastFrame
					(+= temp0 16)
				)
				(if interval
					(= temp1 interval)
					(+= temp0 32)
				)
				(if (== dir -1)
					(+= temp0 128)
				)
				(= temp3 (PlayVMD 14 temp0 temp1)) ; WaitEvent
				(if (and (not loop) (== temp3 1))
					(= temp2 1)
					(continue)
				)
				(if (and (== temp3 8) hotSet)
					(hotSet check:)
					(gTheDoits doit:)
					(FrameOut)
					(continue)
				)
				(if (== temp3 4)
					(gUser doit:)
				else
					loop
				)
			)
		)
		(if (and argc param1)
			(param1 cue:)
		)
	)

	(method (close)
		(PlayVMD 6) ; Close
	)

	(method (setPalette)
		(PlayVMD 7) ; SetPalette
	)

	(method (showCursor param1)
		(PlayVMD 16 param1) ; ShowCursor
	)

	(method (getStatus)
		(PlayVMD 10) ; GetStatus
	)
)

