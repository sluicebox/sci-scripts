;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use GloryRm)
(use PuzzleBar)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	local0
)

(procedure (localproc_0)
	(switch local0
		(0
			(gCurRoom newRoom: 140)
		)
		(1
			(gCurRoom newRoom: 54) ; import
		)
		(2
			(gGlory restore:)
			(optionPanel init: show: dispose:)
			(localproc_0)
		)
		(3
			(gCurRoom newRoom: 160)
		)
		(4
			(= gQuit 1)
		)
	)
)

(instance rm100 of GloryRm
	(properties
		picture 130
	)

	(method (init)
		(LoadMany rsVIEW 100 935)
		(SetFlag 50)
		(ClearFlag 6)
		(if (OneOf gPrevRoomNum 140 54) ; import
			(= picture 130)
			(= style 0)
			(super init: &rest)
			(aShadows init:)
			(theBat init:)
			(aQuest init:)
			(SetFlag 51)
			(self setScript: doPanel)
		else
			(= picture 130)
			(SetFlag 51)
			(super init: &rest)
			(doMovie start: 8)
			(self setScript: doMovie)
		)
	)

	(method (dispose)
		(ClearFlag 50)
		(ClearFlag 51)
		(super dispose:)
	)
)

(instance doPanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 51)
				(optionPanel init: show: dispose:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance doMovie of Script
	(properties)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (OneOf (event type:) evKEYBOARD $0020 evMOUSEBUTTON) (< state 6)) ; joyUp
			(gLongSong client: 0)
			(if (!= state 5)
				(self seconds: 0 changeState: 5)
			else
				(self seconds: 0 changeState: 6)
			)
			(event claimed: 1)
			(return event)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Palette 1 100 2) ; PalLoad
				(gLongSong number: 100 setLoop: 1 play: self)
				(gGlory handsOff:)
				(= ticks 1)
			)
			(1
				(PalVary 1 0 0) ; PalVaryReverse
				(Palette 2 0 255 100) ; PalIntensity
				(= seconds 7)
			)
			(2 0)
			(3 0)
			(4 0)
			(6
				(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
				(= cycles 2)
			)
			(7
				(= cycles 2)
			)
			(8
				(PalVary 3) ; PalVaryKill
				(Palette 2 0 255 100) ; PalIntensity
				(if (FileIO fiEXISTS {flythru.seq})
					(gLongSong number: 101 setLoop: -1 play:)
					(gLongSong2 number: 102 setLoop: -1 play:)
					(SetVideoMode 1)
					(ShowMovie {flythru.seq} 8)
				else
					(if (!= (gLongSong number:) 130)
						(gLongSong setLoop: -1 number: 130 play:)
					)
					(gLongSong2 number: 131 setLoop: 1 play:)
					(aQuest init:)
					(aShadows init:)
					(++ state)
				)
				(ClearFlag 51)
				(gGlory handsOff:)
				(SetFlag 51)
				(= ticks 1)
			)
			(9)
			(10
				(= ticks 120)
			)
			(11
				(theBat init: setPri: 13 posn: 164 156 setCycle: End)
				(= ticks 270)
			)
			(12
				(= ticks 90)
			)
			(13
				(ClearFlag 51)
				(optionPanel init: show: dispose:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance optionPanel of PuzzleBar
	(properties
		state 0
	)

	(method (addIcons))

	(method (init)
		(super init: &rest)
		(self changeCursor: 999)
	)

	(method (setPlane)
		(= usePlane 1)
		(plane bitmap: 0)
		(plane
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 82 40 258 165
			setBitmap: 935 0 0 1
			addCast: puzzleCast
		)
	)

	(method (resetPuzzle &tmp temp0)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(self
				add:
					((choiceIcon new:)
						nsLeft: 11
						x: 11
						nsTop: (+ (* temp0 20) 10)
						y: (+ (* temp0 20) 10)
						loop: temp0
						value: temp0
						init: self
						yourself:
					)
			)
		)
		(self eachElementDo: #show)
	)
)

(instance choiceIcon of TextIcon
	(properties
		view 100
	)

	(method (highlight param1 param2)
		(if (> argc 1)
			(= cel (if param2 1 else 2))
		else
			(= cel (if param1 0 else 2))
		)
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (select)
		(if (super select: &rest)
			(= local0 loop)
			(optionPanel state: (& (optionPanel state:) $ffdf))
		)
	)
)

(instance theBat of Prop
	(properties
		x 162
		y 153
		view 130
		loop 1
	)
)

(instance aQuest of View
	(properties
		x 86
		y 37
		view 130
		loop 2
		signal 16384
	)
)

(instance aShadows of View
	(properties
		x 158
		y 155
		view 130
		signal 16384
	)
)

