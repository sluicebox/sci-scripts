;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1112)
(include sci.sh)
(use Main)
(use Str)
(use Window)
(use System)

(local
	local0
)

(class VMDMovie of Obj
	(properties
		plane -1
		priority -1
		x 30
		y 40
		loop 0
		left 30
		right 30
		bottom 40
		top 40
		mouseDownAction 0
		movieName 0
		frameRate -1
		options 0
		begPic 0
		endPic 0
		firstFrame -1
		lastFrame -1
		interval 0
		rgbBoost 0
		cacheSize 512
		preLoadPCT 100
		colorLow 0
		colorHigh 191
		waitEvents 3
		showCursor 0
		hotSpotSet 0
	)

	(method (dispose)
		(if hotSpotSet
			(hotSpotSet dispose:)
			(= hotSpotSet 0)
		)
		(= mouseDownAction 0)
		(self close:)
		(super dispose:)
	)

	(method (doubled param1)
		(if argc
			(if param1
				(|= options $0001)
			else
				(&= options $fffe)
			)
		)
		(return (& options $0001))
	)

	(method (boostRGB param1)
		(if argc
			(if param1
				(|= options $0010)
			else
				(&= options $ffef)
			)
			(= rgbBoost param1)
		)
		(return (& options $0010))
	)

	(method (setOptions param1)
		(while argc
			(-- argc)
			(|= options [param1 argc])
		)
		(return options)
	)

	(method (blackLines param1)
		(if argc
			(if param1
				(|= options $0004)
				(if (not rgbBoost)
					(self boostRGB: 25)
				)
			else
				(&= options $fffb)
			)
		)
		(return (& options $0004))
	)

	(method (dropFrames param1)
		(if argc
			(if param1
				(|= options $0002)
			else
				(&= options $fffd)
			)
		)
		(return (& options $0002))
	)

	(method (holdBlackFrame param1)
		(if argc
			(if param1
				(|= options $0020)
			else
				(&= options $ffdf)
			)
		)
		(return (& options $0020))
	)

	(method (holdLastFrame param1)
		(if argc
			(if param1
				(|= options $0040)
			else
				(&= options $ffbf)
			)
		)
		(return (& options $0040))
	)

	(method (stretch param1)
		(if argc
			(if param1
				(|= options $0100)
			else
				(&= options $feff)
			)
		)
		(return (& options $0100))
	)

	(method (getFrame)
		(PlayVMD 26)
	)

	(method (setPalette)
		(PlayVMD 7) ; SetPalette
	)

	(method (showTheCursor param1)
		(PlayVMD 16 param1) ; ShowCursor
	)

	(method (getStatus)
		(PlayVMD 10) ; GetStatus
	)

	(method (play param1)
		(repeat
			(self VMD_Play:)
			(if (not local0)
				(break)
			)
		)
		(if argc
			(param1 cue:)
		)
	)

	(method (delayPlay param1)
		(if argc
			(playScript scratch: param1)
		)
		(self open:)
		(gCurRoom setScript: playScript)
	)

	(method (VMD_Play &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp2 0)
		(= local0 loop)
		(= temp0 options)
		(= temp5 waitEvents)
		(if (!= lastFrame -1)
			(|= waitEvents $0010)
			(= temp2 lastFrame)
		)
		(if hotSpotSet
			(|= temp5 $0008)
		)
		(if interval
			(= temp2 interval)
			(|= temp5 $0020)
		)
		(|= temp0 $0040)
		(if rgbBoost
			(= temp3 (if (!= colorLow -1) colorLow else 0))
			(= temp4 (if (!= colorLow -1) colorHigh else 255))
		)
		(PlayVMD 16 1) ; ShowCursor
		(if (not showCursor)
			(gGame handsOff:)
		)
		(if (!= frameRate -1)
			(PlayVMD 31 frameRate) ; SetFrameRate
		)
		(if (not (self open:))
			(gGame handsOn:)
			(return gVMDMovie)
		)
		(if rgbBoost
			(PlayVMD 1 x y temp0 rgbBoost temp3 temp4) ; Put
		else
			(PlayVMD 1 x y temp0) ; Put
		)
		(repeat
			(if hotSpotSet
				(hotSpotSet activate:)
			)
			(switch (= temp1 (PlayVMD 14 temp5 temp2)) ; WaitEvent
				(4
					(if hotSpotSet
						(gUser doit:)
						(if (== mouseDownAction 1)
							(self mouseDownAction: 0)
							(= local0 0)
							(break)
						)
					else
						(= local0 0)
						(break)
					)
				)
				(8
					(hotSpotSet check: 1)
				)
				(1
					(if gQuit
						(= local0 0)
					)
					(break)
				)
				(else
					(= local0 0)
					(break)
				)
			)
			(if (not gVMDMovie)
				(= local0 0)
				(break)
			)
		)
		(if hotSpotSet
			(hotSpotSet deactivate:)
		)
		(self close:)
		(gGame handsOn:)
		(return 1)
	)

	(method (open &tmp temp0)
		(if (!= gVMDMovie self)
			(self close:)
		else
			(= gVMDMovie self)
			(return)
		)
		(if (and movieName (not (ResCheck 151 movieName))) ; VMD
			(PrintDebug {Unable to find %d.vmd} movieName)
			(= gVMDMovie 0)
			(return)
		)
		(if begPic
			(gCurRoom drawPic: begPic)
			(FrameOut)
		)
		(if (and cacheSize preLoadPCT)
			(PlayVMD 28 preLoadPCT) ; SetPreload
		)
		(= temp0 (Str format: {%d.vmd} movieName))
		(PlayVMD 0 (temp0 data:) cacheSize) ; Open
		(temp0 dispose:)
		(if (and (!= colorLow -1) (!= colorHigh -1))
			(PlayVMD 23 colorLow colorHigh) ; RestrictPalette
		)
		(cond
			((!= priority -1)
				(PlayVMD 27 priority) ; SetPlane
			)
			((!= plane -1)
				(PlayVMD 27 (+ (plane priority:) 1)) ; SetPlane
			)
		)
		(= gVMDMovie self)
	)

	(method (close)
		(if gVMDMovie
			(if (== gVMDMovie self)
				(if endPic
					(gCurRoom drawPic: endPic)
				)
				(self doVerb: 3)
			)
			(PlayVMD 6) ; Close
			(= gVMDMovie 0)
		)
	)

	(method (enableHotSpots param1 param2 &tmp temp0 temp1)
		(self showCursor: 1)
		(if argc
			(if (not hotSpotSet)
				(= hotSpotSet (HotRectangleSet new:))
			)
			(|= waitEvents $000c)
			(|= options $0040)
			(for ((= temp0 0)) (< temp0 (- argc 1)) ((++ temp0))
				([param2 temp0] init:)
				(hotSpotSet add: [param2 temp0])
			)
			(if param1
				(= temp1 (global124 theFtrs:))
				(for ((= temp0 0)) (< temp0 (temp1 size:)) ((++ temp0))
					(hotSpotSet add: (temp1 at: temp0))
				)
				(hotSpotSet activate:)
			)
		)
	)

	(method (doVerb))
)

(instance playScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(self scratch: gVMDMovie)
				(gVMDMovie play:)
				(self register: 0)
				(self scratch: 0)
				(self dispose:)
			)
		)
	)
)

