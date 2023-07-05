;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62996)
(include sci.sh)
(use Main)
(use MenuList)
(use n63002)
(use DItem)
(use Plane)
(use Rectangle)
(use FlipPoly)
(use Cel)
(use Menu)
(use System)

(public
	playback 0
)

(class playback of Plane
	(properties
		buttons 0
		pageArea 0
	)

	(method (init param1 &tmp temp0)
		(= pageArea
			(Rectangle
				new:
					177
					34
					514
					(+ 33 (* (VMDMenu lineHeight:) (VMDMenu pageSize:)))
			)
		)
		(= picture -2)
		(self setPri: (+ 1 (GetHighPlanePri)))
		(super init: 0 70 640 406)
		(playbackFrame setPri: 10 init: self)
		(= buttons (Set new:))
		(buttons add: (chapterButton new: 1))
		(buttons add: (chapterButton new: 2))
		(buttons add: (chapterButton new: 3))
		(buttons add: (chapterButton new: 4))
		(buttons add: (chapterButton new: 5))
		(buttons eachElementDo: #init self)
		(= temp0
			(if argc
				(- param1 1)
			else
				0
			)
		)
		((buttons at: temp0) isDown: 1 update:)
		(exitButton init: self)
		(VMDMenu init: gChapter)
		((gUser hogs:) push: self 1)
		(= global238 1)
	)

	(method (dispose)
		(= global238 0)
		(pageArea dispose:)
		(= pageArea 0)
		(if buttons
			(buttons release: dispose:)
			(= buttons 0)
		)
		(VMDMenu dispose:)
		(super dispose: &rest)
	)

	(method (done param1)
		((gUser hogs:) pop:)
		(if (and argc (!= param1 -1))
			(= global211 (= global212 1))
			(if (== param1 340)
				(proc63002_7 (+ 340 (Random 0 14)))
			else
				(proc63002_7 param1)
			)
			(= scratch 1)
			(Send new: self 8)
			(PrintDebug {VMD: %d} param1)
		else
			(self dispose:)
		)
	)

	(method (handleEvent event)
		(event localize: self)
		(FrameOut)
		(if (pageArea onMe: event)
			(VMDMenu doit: (event x:) (event y:))
		else
			(VMDMenu doit: 0)
		)
		(FrameOut)
		(super handleEvent: event)
	)

	(method (newChapter param1 &tmp temp0 temp1 [temp2 2])
		(= temp0 (param1 loop:))
		(= temp1 (buttons firstTrue: #isDown))
		(temp1 isDown: 0 update:)
		(param1 isDown: 1 update:)
		(VMDMenu dispose:)
		(FrameOut)
		(VMDMenu init: temp0)
	)

	(method (setAllMovieFlags &tmp temp0)
		(return 0)
	)
)

(instance VMDMenu of VMultiLineSelector
	(properties
		pageSize 22
		lineHeight 12
		topLineNum 0
	)

	(method (init param1 &tmp temp0 temp1)
		(= temp0 (+ 6301 param1))
		(= temp1
			(switch param1
				(1
					(ScriptID 63025) ; realCH1VMDTable
				)
				(2
					(ScriptID 63026) ; realCH2VMDTable
				)
				(3
					(ScriptID 63027) ; realCH3VMDTable
				)
				(4
					(ScriptID 63028) ; realCH4VMDTable
				)
				(5
					(ScriptID 63029) ; realCH5VMDTable
				)
			)
		)
		((= items (MenuList new: self))
			flags: temp1
			init: SelectItem 177 34 338 temp0 param1
		)
		(items eachElementDo: #init gPlayback)
		(self cue: 0)
		(super init:)
		(if (> numLines pageSize)
			((= scrollBar vmdScroll)
				client: self
				init:
				clientMax: (- numLines pageSize)
				clientPageSize: pageSize
			)
		)
	)

	(method (dispose)
		(= topLineNum 0)
		(super dispose:)
	)
)

(instance playbackFrame of Cel
	(properties
		view 4020
	)
)

(instance vmdScroll of Scrollbar
	(properties)

	(method (init)
		(= thumbMax (- (tThumb thumbMax:) (tThumb thumbMin:)))
		(= thumbSize 14)
		(super init: gPlayback dnArr upArr tThumb tDn tUp tBar)
	)

	(method (dispose)
		(forwardArrow dispose:)
		(reverseArrow dispose:)
		(thumbButton dispose:)
		(forwardRegion dispose:)
		(reverseRegion dispose:)
		(physicalBar dispose:)
		(= clientPosition
			(= reverseRegion
				(= physicalBar
					(= client
						(= forwardArrow
							(= reverseArrow (= thumbButton (= forwardRegion 0)))
						)
					)
				)
			)
		)
		(super dispose:)
	)
)

(instance upArr of ScrollbarArrow
	(properties
		x 538
		y 30
		view 4020
		loop 9
	)

	(method (init)
		(= cueSelector 441)
		(super init: &rest)
	)

	(method (update)
		(= cel 0)
		(if (not (not (& state $0020)))
			(++ cel)
		)
		(UpdateScreenItem self)
		(self setRect:)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)
)

(instance dnArr of ScrollbarArrow
	(properties
		x 538
		y 292
		view 4020
		loop 8
	)

	(method (init)
		(= cueSelector 440)
		(super init: &rest)
	)

	(method (update)
		(= cel 0)
		(if (not (not (& state $0020)))
			(++ cel)
		)
		(UpdateScreenItem self)
		(self setRect:)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)
)

(instance tThumb of Thumb
	(properties
		x 538
		y 41
		view 4020
		loop 7
		thumbMax 278
		thumbMin 41
	)

	(method (init)
		(self setPri: 600)
		(super init: &rest)
	)

	(method (update)
		(= cel 0)
		(UpdateScreenItem self)
		(self setRect:)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)
)

(instance tBar of Cel
	(properties
		x 538
		y 41
		view 4020
		loop 10
	)

	(method (init)
		(self setPri: 40)
		(super init: &rest)
	)
)

(instance tUp of PageRegion
	(properties
		x 538
		y 41
		celHeight 0
		celWidth 16
	)

	(method (init)
		(self setPri: 400)
		(super init: &rest)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)
)

(instance tDn of PageRegion
	(properties
		type 1
		x 538
		y 55
		celHeight 237
		celWidth 16
	)

	(method (init)
		(self setPri: 400)
		(super init: &rest)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)
)

(class ToggleButton of DItem
	(properties
		isDown 0
	)

	(method (update)
		(= cel 0)
		(if (or isDown (not (not (& state $0020))))
			(++ cel)
		)
		(super update: &rest)
	)

	(method (action)
		(if isDown
			(return)
		)
		(gPlayback newChapter: self)
	)
)

(instance chapterButton of ToggleButton
	(properties
		x 70
		view 4020
	)

	(method (new param1 &tmp temp0)
		(= temp0 (super new:))
		(temp0 loop: param1)
		(return temp0)
	)

	(method (init)
		(= y
			(switch loop
				(1 16)
				(2 65)
				(3 114)
				(4 163)
				(5 205)
			)
		)
		(super init: &rest)
		(|= state $1000)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)
)

(instance exitButton of DItem
	(properties
		x 70
		y 253
		view 4020
		loop 6
	)

	(method (init)
		(super init: &rest)
		(|= state $1000)
	)

	(method (update)
		(= cel 0)
		(if (not (not (& state $0020)))
			(++ cel)
		)
		(super update: &rest)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)

	(method (action)
		(gPlayback done:)
	)
)

