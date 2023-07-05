;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use LightRoom)
(use Plane)
(use Print)
(use Sound)
(use Actor)
(use System)

(public
	changeDisk 0
)

(instance changeDisk of LightRoom
	(properties)

	(method (init)
		(super init: &rest)
		(cond
			((not (and global224 global225))
				(Prints
					{You provided neither newDisk nor newDiskRoom, this will probably crash.}
				)
			)
			((not global224)
				(Prints {You didn't provide a newDisk.})
			)
			((not global225)
				(Prints {You didn't provide a newDiskRoom.})
			)
		)
		(if (== global224 gNumCD)
			(gCurRoom newRoom: global225)
		else
			(getDisk doit: global224)
			(gCurRoom newRoom: global225)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance getDisk of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(not (or (== param1 1) (== param1 2)))
		(= gNumCD param1)
		(= temp3 (= temp2 0))
		(if (and (!= -1 (= temp0 (CD 0 param1))) (!= temp0 param1)) ; Check
			(gGame setCursor: gTheInvisCursor 1)
			(Palette 2 0 255 0) ; PalIntensity
			(FrameOut)
			(= temp3 (Cast new:))
			((= temp2 (Plane new:))
				picture: 0
				back: 0
				init: 0 0 639 479
				priority: (+ (GetHighPlanePri) 1)
				addCast: (temp3 plane: temp2 yourself:)
			)
			(switch gNumCD
				(1
					(switch (gGame language:)
						(1
							(= temp4 1111)
						)
						(33
							(= temp4 1113)
						)
						(49
							(= temp4 1115)
						)
					)
					(Load rsAUDIO temp4)
					(discSound number: temp4 setLoop: 0)
				)
				(2
					(switch (gGame language:)
						(1
							(= temp4 1112)
						)
						(33
							(= temp4 1114)
						)
						(49
							(= temp4 1116)
						)
					)
					(Load rsAUDIO temp4)
					(numberView setCel: 0 init: temp3)
					(discSound number: temp4 setLoop: 0)
				)
			)
			(changeView init: temp3)
			(UpdateScreenItem changeView)
			(if (!= gNumCD 1)
				(UpdateScreenItem numberView)
			)
			(UpdatePlane temp2)
			(Palette 2 0 255 100) ; PalIntensity
			(FrameOut)
			(while (and (!= -1 (= temp0 (CD 0 param1))) (!= temp0 param1)) ; Check
				(discSound play:)
				(while ((= temp1 (Event new:)) type:)
					(temp1 dispose:)
				)
				(temp1 dispose:)
				(for
					((= temp1 (Event new:)))
					(and (!= (temp1 message:) KEY_RETURN) (not (& (temp1 type:) evKEYBOARD)))
					((= temp1 (Event new:)))
					
					(temp1 dispose:)
				)
				(discSound stop:)
				(temp1 dispose:)
			)
			(temp2 dispose:)
		)
		(return temp0)
	)
)

(instance changeView of View
	(properties
		view 20
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1000)
	)
)

(instance numberView of View
	(properties
		x 417
		y 135
		view 20
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1001)
	)
)

(instance discSound of Sound
	(properties
		flags 5
	)
)

