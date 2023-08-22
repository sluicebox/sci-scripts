;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64926)
(include sci.sh)
(use Main)
(use DItem)
(use WriteFeature)
(use Button)
(use System)

(class Scrollbar of Obj
	(properties
		client 0
		physicalBar 0
		forwardArrow 0
		reverseArrow 0
		thumbButton 0
		forwardRegion 0
		reverseRegion 0
		thumbSize 0
		thumbPosition 0
		clientPosition 0
		thumbMax 0
		clientMax 0
		clientPageSize 0
	)

	(method (init param1 param2 param3 param4 param5 param6 param7)
		(= forwardArrow param2)
		(= reverseArrow param3)
		(= thumbButton param4)
		(= forwardRegion param5)
		(= reverseRegion param6)
		(= physicalBar param7)
		(physicalBar init: param1)
		(param4 init: param1 self)
		(param2 init: param1 self)
		(param3 init: param1 self)
		(param5 init: param1 self)
		(param6 init: param1 self)
	)

	(method (advance &tmp temp0)
		(if (!= clientPosition clientMax)
			(++ clientPosition)
			(self updateThumb:)
			(client cue: clientPosition)
		)
	)

	(method (retreat &tmp temp0)
		(if clientPosition
			(-- clientPosition)
			(self updateThumb:)
			(client cue: clientPosition)
		)
	)

	(method (advancePage &tmp temp0)
		(+= clientPosition clientPageSize)
		(if (> clientPosition clientMax)
			(= clientPosition clientMax)
		)
		(self updateThumb:)
		(client cue: clientPosition)
	)

	(method (retreatPage &tmp temp0)
		(-= clientPosition clientPageSize)
		(if (< clientPosition 0)
			(= clientPosition 0)
		)
		(self updateThumb:)
		(client cue: clientPosition)
	)

	(method (move param1 param2)
		(cond
			((and (> argc 1) param2)
				(if (<= param1 clientMax)
					(= clientPosition param1)
					(self updateThumb:)
				)
			)
			((!= param1 thumbPosition)
				(if (< param1 0)
					(= param1 0)
				)
				(if (> param1 thumbMax)
					(= param1 thumbMax)
				)
				(= thumbPosition param1)
				(= clientPosition (MulDiv thumbPosition clientMax thumbMax))
				(self update:)
				(client cue: clientPosition)
			)
		)
	)

	(method (updateThumb &tmp temp0)
		(= temp0 (MulDiv clientPosition thumbMax clientMax))
		(if (!= thumbPosition temp0)
			(= thumbPosition temp0)
			(self update:)
		)
	)

	(method (update)
		(thumbButton posn: thumbPosition)
		(forwardRegion setSize: (- thumbMax thumbPosition))
		(reverseRegion setSize: thumbPosition)
	)
)

(class ScrollbarArrow of Button
	(properties
		cueSelector -1
	)

	(method (init param1 param2)
		(= client param2)
		(super init: param1)
	)

	(method (action)
		(Eval client cueSelector)
		(FrameOut)
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event)
		else
			(cond
				((not (not (& state $0020)))
					(event localize: plane)
					(self track: event)
					(cond
						((& evMOUSERELEASE (event type:))
							(self press: 0)
							((gUser hogs:) pop:)
						)
						((not (not (& state $0002)))
							(self action:)
						)
					)
				)
				((& evMOUSEBUTTON (event type:))
					(self press: 1)
					((gUser hogs:) push: self 1)
				)
			)
			(event claimed: self)
		)
		(event claimed:)
	)
)

(class Thumb of Button
	(properties
		thumbPosition -1
		thumbMax -1
		thumbMin -1
		dx -1
		dy -1
	)

	(method (init param1 param2)
		(= client param2)
		(|= state (& (client state:) $0080))
		(client
			thumbSize:
				(if (& state $0080)
					(CelWide view loop cel)
				else
					(CelHigh view loop cel)
				)
		)
		(self posn: 0)
		(super init: param1)
	)

	(method (action param1 &tmp temp0 temp1 temp2)
		(if argc
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
			(= temp2
				(-
					(= temp2
						(if (& state $0080)
							(- temp0 dx)
						else
							(- temp1 dy)
						)
					)
					thumbMin
				)
			)
		else
			(= temp2 thumbPosition)
		)
		(client move: temp2)
		(self track: param1)
		(FrameOut)
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event)
		else
			(cond
				((not (not (& state $0020)))
					(event localize: plane)
					(self track: event)
					(if (& evMOUSERELEASE (event type:))
						(self press: 0)
						((gUser hogs:) pop:)
					)
					(cond
						(((client physicalBar:) onMe: event)
							(self action: event)
						)
						((not (not (not (& state $0020))))
							(self action:)
						)
					)
				)
				((& evMOUSEBUTTON (event type:))
					(self press: 1)
					(= thumbPosition (if (& state $0080) x else y))
					(-= thumbPosition thumbMin)
					(= dx (- (event x:) x))
					(= dy (- (event y:) y))
					((gUser hogs:) push: self 1)
				)
			)
			(event claimed: self)
		)
		(event claimed:)
	)

	(method (posn param1 &tmp temp0 temp1)
		(if (or (< (+= param1 thumbMin) thumbMin) (> param1 thumbMax))
			(PrintDebug {Illegal pos: %d!<%d!<%d} thumbMin param1 thumbMax)
			(SetDebug self)
		)
		(if (& state $0080)
			(= temp0 param1)
			(= temp1 y)
		else
			(= temp1 param1)
			(= temp0 x)
		)
		(super posn: temp0 temp1 (not (& signal $0008)))
	)
)

(class PageRegion of DItem
	(properties
		state 1793
		type -1
		celHeight -1
		celWidth -1
		fore 36
		skip 0
	)

	(method (init param1 param2 &tmp temp0)
		(|= signal $1000)
		(= client param2)
		(|= state (& (client state:) $0080))
		(= plane
			(cond
				(argc param1)
				(plane plane)
				(else gThePlane)
			)
		)
		((plane cast:) add: self)
		(if celHeight
			(self update:)
		)
	)

	(method (action)
		(if (== type 1)
			(client advancePage:)
		else
			(client retreatPage:)
		)
		(FrameOut)
	)

	(method (draw param1 param2)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
		)
		(= bitmap
			(Bitmap
				0 ; Create
				param1
				param2
				skip
				(if (not (not (& state $0020))) fore else skip)
			)
		)
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event)
		else
			(cond
				((not (not (& state $0020)))
					(event localize: plane)
					(if (& evMOUSERELEASE (event type:))
						(self press: 0)
						((gUser hogs:) pop:)
					)
					(if (self onMe: event)
						(self action:)
					)
				)
				((& evMOUSEBUTTON (event type:))
					(self press: 1)
					((gUser hogs:) push: self 1)
				)
			)
			(event claimed: self)
		)
		(event claimed:)
	)

	(method (setSize param1 &tmp temp0 temp1 temp2)
		(if (= temp0 (- param1 celHeight))
			(= celHeight param1)
			(if (& state $0080)
				(= temp1 celHeight)
				(= temp2 celWidth)
				(if (== type 1)
					(-= x temp0)
				)
			else
				(= temp1 celWidth)
				(= temp2 celHeight)
				(if (== type 1)
					(-= y temp0)
				)
			)
			(self update: temp1 temp2)
		)
	)

	(method (update param1 param2 &tmp temp0 temp1)
		(if celHeight
			(cond
				((== argc 2)
					(= temp0 param1)
					(= temp1 param2)
				)
				((& state $0080)
					(= temp0 celHeight)
					(= temp1 celWidth)
				)
				(else
					(= temp1 celHeight)
					(= temp0 celWidth)
				)
			)
			(self draw: temp0 temp1)
			(if (not (& signal $0008))
				(super update:)
			else
				(self show:)
				(self setRect:)
			)
		else
			(self hide:)
		)
	)
)

