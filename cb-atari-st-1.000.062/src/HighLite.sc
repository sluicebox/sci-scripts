;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 214)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)

(class HighLite of Prop
	(properties
		highLiteX 0
		highLiteY 0
		deltaX 0
		deltaY 0
		leadingEdge 0
		ignoreCast 0
		eyesID 0
	)

	(method (init)
		(super init:)
		(self HighLitePosn:)
		(self
			view: 151
			loop: 1
			cel: 0
			setPri: 2
			posn: highLiteX highLiteY
			ignoreActors: 1
			setCycle: Fwd
		)
		(self leadingEdge: (/ (+ (- (self brRight:) (self brLeft:)) 1) 2))
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(self HighLitePosn:)
		(self posn: highLiteX highLiteY)
		(if (not ignoreCast)
			(for ((= temp0 (gCast first:))) temp0 ((= temp0 temp1))
				(= temp1 (gCast next: temp0))
				(if
					(and
						(IsObject (= temp2 (NodeValue temp0)))
						(!= temp2 gEgo)
						(!= temp2 self)
						(!= temp2 eyesID)
					)
					(= temp3 (- (temp2 x:) (self x:)))
					(if (>= leadingEdge (Abs temp3))
						(= temp5 (NumCels temp2))
						(if
							(<
								(= temp4
									(+
										(/
											(*
												(+
													(/
														(* temp3 1000)
														leadingEdge
													)
													5
												)
												(/ temp5 2)
											)
											1000
										)
										(/ temp5 2)
									)
								)
								temp5
							)
							(temp2 show: cel: temp4 forceUpd:)
						)
					else
						(temp2 hide:)
					)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
	)

	(method (HighLitePosn &tmp temp0)
		(if (or (== (= temp0 (gEgo loop:)) 2) (== temp0 1))
			(= highLiteX (- (gEgo x:) deltaX))
		else
			(= highLiteX (+ (gEgo x:) deltaX))
		)
		(= highLiteY (- (gEgo y:) deltaY))
	)
)

