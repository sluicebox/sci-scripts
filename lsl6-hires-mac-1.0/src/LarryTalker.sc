;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use fileScr)
(use Plane)
(use Str)
(use Print)
(use Talker)
(use Actor)
(use System)

(public
	LarryTalker 0
	curTalkerbust 1
	larryTBust 3
)

(class LarryTalker of Talker
	(properties
		talkWidth 175
		modeless 2
		priority 200
		winPosn 0
		showFrame 1
		faceCast 0
		fullFace 0
		curText 0
		strHandle 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0 temp1)
		(= global213 gTheCursor)
		(= global212 (gUser input:))
		(= global211 (gUser controls:))
		(if (not font)
			(= font gUserFont)
		)
		(cond
			(faceCast)
			(fullFace
				(if (gCurRoom inset:)
					(((gCurRoom inset:) plane:)
						addCast:
							(= faceCast
								((Cast new:) name: {faceCast} init: yourself:)
							)
					)
				else
					(gThePlane
						addCast:
							(= faceCast
								((Cast new:) name: {faceCast} init: yourself:)
							)
					)
				)
			)
			(else
				(gTalkerPlane
					addCast:
						(= faceCast
							((Cast new:) name: {faceCast} init: yourself:)
						)
				)
			)
		)
		(switch winPosn
			(1
				(= textX 160)
				(= textY 10)
				(= talkWidth 130)
				(= x 38)
				(= y 0)
			)
			(2
				(= textX -220)
				(= textY 10)
				(= x 280)
				(= y 2)
				(= talkWidth 145)
			)
		)
		(= temp0 (self x:))
		(= temp1 (self y:))
		(if argc
			(if param1
				((= mouth (param1 new:))
					x: (+ (param1 x:) temp0)
					y: (+ (param1 y:) temp1)
				)
			)
			(if (> argc 1)
				(if param2
					((= bust (param2 new:))
						x: (+ (param2 x:) temp0)
						y: (+ (param2 y:) temp1)
					)
				)
				(if (> argc 2)
					(if param3
						((= eyes (param3 new:))
							x: (+ (param3 x:) temp0)
							y: (+ (param3 y:) temp1)
						)
					)
					(if (> argc 3)
						(= frame param4)
					)
				)
			)
		)
		(= initialized 1)
		(gTalkers addToFront: self)
		(if (and (not frame) showFrame)
			((= frame (View new:))
				name: {frame}
				view: (self view:)
				loop: (self loop:)
				cel: (self cel:)
				x: temp0
				y: temp1
				setPri: priority
				init: faceCast
			)
		)
		(if (not mouth)
			(= mouth
				((Prop new:)
					name: {mouth}
					view: 98
					loop: 0
					cel: 0
					x: x
					y: y
					yourself:
				)
			)
		)
		(mouth init: faceCast setPri: priority)
		(if bust
			(bust setPri: priority init: faceCast)
		)
		(if eyes
			(eyes setPri: priority init: faceCast)
		)
		(if frame
			(frame setPri: priority init: faceCast)
		)
	)

	(method (startText param1 &tmp temp0)
		(= temp0 (param1 size:))
		(= ticks (Max 120 (* (/ (* 24 temp0) 10) gTextSpeed)))
		(super startText: param1 &rest)
	)

	(method (display param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(gGame setCursor: gWaitCursor 1)
		(= temp3
			(cond
				(frame frame)
				(bust bust)
				(else mouth)
			)
		)
		(= temp4 (Print new:))
		(if (not (+ textX textY))
			(= textX (+ (CelWide (temp3 view:) (temp3 loop:) (temp3 cel:)) 5))
		)
		(if (> (+ (= temp2 (+ (temp3 nsLeft:) textX)) talkWidth) 318)
			(= temp1 (- 318 temp2))
		else
			(= temp1 talkWidth)
		)
		(if gTextScroller
			(temp4 plane: invisiblePlane)
		)
		(if showTitle
			(temp4 addTitle: name)
		)
		(temp4
			back: back
			posn: (+ (temp3 x:) textX) (+ (temp3 y:) textY)
			modeless: 2
			font: font
			width: temp1
			addText: param1
			init:
		)
		(gPrints delete: temp4)
		(= dialog (temp4 dialog:))
		(if gTextScroller
			(= strHandle (Str format: {%s\n} (self name:)))
			(gTextScroller addString: (strHandle data:) 2408 fore 0)
			(strHandle dispose:)
			(= strHandle (Str format: {%s\n\n} param1))
			(= curText (gTextScroller addString: (strHandle data:) font 57 0 0))
		)
	)

	(method (doit)
		(if faceCast
			(faceCast doit:)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gUser canInput: global212 canControl: global211)
		(gGame setCursor: global213)
		(if faceCast
			(faceCast dispose:)
			(= mouth (= eyes (= bust (= frame (= faceCast 0)))))
		)
		(if curText
			(gTextScroller modifyString: curText (strHandle data:) font fore 0 0)
			(strHandle dispose:)
			(= curText 0)
		)
		(super dispose: &rest)
	)
)

(class LarryNarrator of Narrator
	(properties
		modeless 2
		curText 0
		strHandle 0
	)

	(method (init)
		(= global213 gTheCursor)
		(= global212 (gUser input:))
		(= global211 (gUser controls:))
		(= font gUserFont)
		(super init: &rest)
	)

	(method (startText param1 &tmp temp0)
		(= temp0 (param1 size:))
		(= ticks (Max 120 (* (/ (* 24 temp0) 10) gTextSpeed)))
		(super startText: param1 &rest)
	)

	(method (startAudio param1)
		(= audModNum (param1 at: 0))
		(= audNoun (param1 at: 1))
		(= audVerb (param1 at: 2))
		(= audCase (param1 at: 3))
		(= audSequence (param1 at: 4))
		(if (ResCheck 146 audModNum audNoun audVerb audCase audSequence) ; CHUNK
			(gGame setCursor: gWaitCursor 1)
			(= ticks (DoAudio audPLAY audModNum audNoun audVerb audCase audSequence))
		else
			(= gMsgType 1)
		)
	)

	(method (display param1 &tmp temp0 temp1)
		(if (> (+ x talkWidth) 318)
			(= temp0 (- 318 x))
		else
			(= temp0 talkWidth)
		)
		(= temp1 (Print new:))
		(if gTextScroller
			(temp1 plane: invisiblePlane)
		)
		(if showTitle
			(temp1 addTitle: name)
		)
		(temp1
			fore: fore
			back: back
			posn: x y
			font: font
			width: temp0
			addText: param1
			modeless: 2
			init:
		)
		(gPrints delete: temp1)
		(= dialog (temp1 dialog:))
		(if gTextScroller
			(= strHandle (Str format: {%s\n\n} param1))
			(= curText (gTextScroller addString: (strHandle data:) font 57 0))
		)
	)

	(method (dispose)
		(gGame setCursor: global213)
		(if curText
			(gTextScroller modifyString: curText (strHandle data:) font fore 0 0)
			(strHandle dispose:)
			(= curText 0)
		)
		(= gMsgType 3)
		(super dispose: &rest)
	)
)

(instance invisiblePlane of Plane
	(properties)

	(method (init)
		(= priority -1)
		(super init: &rest)
	)
)

(instance larryTBust of View
	(properties
		x 2
		y 2
		view 1900
		loop 1
	)

	(method (init)
		(if (IsFlag 74)
			(= view 1901)
		)
		(super init: &rest)
	)
)

(instance curTalkerbust of View
	(properties
		x 282
		y 2
		loop 1
	)
)

