;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64983)
(include sci.sh)
(use Main)
(use WriteFeature)

(class Responder of Obj
	(properties
		client 0
		responder 0
	)

	(method (new param1 &tmp temp0)
		(= temp0 (Clone self))
		(if argc
			(temp0 init: param1 &rest)
		)
		(return temp0)
	)

	(method (init param1 &tmp temp0)
		(if argc
			(= client param1)
			(if (and (= temp0 (client responder:)) (!= temp0 self))
				(= responder temp0)
			)
			(client responder: self)
		)
	)

	(method (dispose)
		(client responder: responder)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and responder (not (event claimed:)))
			(responder handleEvent: event &rest)
		)
		(event claimed:)
	)
)

(class Dragger of Responder
	(properties
		state 16
		x 0
		y 0
	)

	(method (dragOrigin param1)
		(if argc
			(if param1
				(|= state $0010)
			else
				(&= state $ffef)
			)
		)
		(return (& state $0010))
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((& state $0008)
				(if (gUser mouseMoved:)
					(event localize: (client plane:))
					(client posn: (+ x (event x:)) (+ y (event y:)) 1)
					(FrameOut)
				)
				(if (and (& evMOUSERELEASE (event type:)) (not (event modifiers:)))
					(event claimed: self)
					((gUser hogs:) pop:)
					(&= state $fff7)
				)
			)
			((and (& evMOUSEBUTTON (event type:)) (not (event modifiers:)))
				(event claimed: self)
				(|= state $0008)
				((gUser hogs:) push: self 1)
				(if (& state $0020)
					(client setPri: (+ 1 (GetHighItemPri (client plane:))))
				)
				(= temp0 (client plane:))
				(= temp1 (+ (temp0 left:) (client x:)))
				(= temp2 (+ (temp0 top:) (client y:)))
				(if (self dragOrigin:)
					(= x (= y 0))
					(SetCursor temp1 temp2)
				else
					(= x (- temp1 gMouseX))
					(= y (- temp2 gMouseY))
				)
			)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(if (& state $0008)
			(&= state $fff7)
			((gUser hogs:) pop:)
		)
		(super dispose: &rest)
	)
)

