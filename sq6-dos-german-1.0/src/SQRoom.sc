;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Game)

(local
	local0
)

(class SQRoom of Room
	(properties
		style 14
		exitStyle 13
	)

	(method (buildPic))

	(method (updateRect &tmp temp0 temp1 temp2 temp3 temp4)
		(cond
			(
				(and
					(> (+ (gEgo x:) (gThePlane left:)) 295)
					(> (gThePlane right:) 325)
					(gEgo mover:)
					(> (gEgo x:) ((gEgo mover:) xLast:))
				)
				(= temp1 (- 310 (/ (- (gEgo nsRight:) (gEgo nsLeft:)) 2)))
				(if (< (= temp2 (- (gThePlane right:) 310)) 325)
					(= temp1 (- (gThePlane right:) 325))
				)
				(gThePlane
					setRect:
						(- (gThePlane left:) temp1)
						(gThePlane top:)
						(- (gThePlane right:) temp1)
						(gThePlane bottom:)
				)
				(UpdatePlane gThePlane)
			)
			(
				(and
					(< (+ (gEgo x:) (gThePlane left:)) 25)
					(< (gThePlane left:) -5)
					(gEgo mover:)
					(< (gEgo x:) ((gEgo mover:) xLast:))
				)
				(= temp1 (- 310 (/ (- (gEgo nsRight:) (gEgo nsLeft:)) 2)))
				(if (> (= temp0 (+ (gThePlane left:) 310)) 0)
					(= temp1 (- 310 temp0))
				)
				(gThePlane
					setRect:
						(+ (gThePlane left:) temp1)
						(gThePlane top:)
						(+ (gThePlane right:) temp1)
						(gThePlane bottom:)
				)
				(UpdatePlane gThePlane)
			)
			(
				(and
					(> (+ (gEgo y:) (gThePlane top:)) 118)
					(> (gThePlane bottom:) 140)
					(gEgo mover:)
					(> (gEgo y:) ((gEgo mover:) yLast:))
				)
				(= temp1 (- 126 (/ (- (gEgo nsBottom:) (gEgo nsTop:)) 2)))
				(if (< (= temp4 (- (gThePlane bottom:) 126)) 140)
					(= temp1 (- (gThePlane bottom:) 140))
				)
				(gThePlane
					setRect:
						(gThePlane left:)
						(- (gThePlane top:) temp1)
						(gThePlane right:)
						(- (gThePlane bottom:) temp1)
				)
				(UpdatePlane gThePlane)
			)
			(
				(and
					(< (+ (gEgo y:) (gThePlane top:)) 25)
					(< (gThePlane top:) -3)
					(gEgo mover:)
					(< (gEgo y:) ((gEgo mover:) yLast:))
				)
				(= temp1 126)
				(if (> (= temp3 (+ (gThePlane top:) 126)) 0)
					(= temp1 (- 126 temp3))
				)
				(gThePlane
					setRect:
						(gThePlane left:)
						(+ (gThePlane top:) temp1)
						(gThePlane right:)
						(+ (gThePlane bottom:) temp1)
				)
				(UpdatePlane gThePlane)
			)
		)
	)

	(method (doit)
		(cond
			((not (IsFlag 202))
				(if (and (not local0) (gEgo code:))
					(= local0 (gEgo code:))
					(gEgo code: 0)
				)
				(self updateRect:)
			)
			((and local0 (not (gEgo code:)))
				(gEgo code: local0)
				(= local0 0)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(if local0
			(= local0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

