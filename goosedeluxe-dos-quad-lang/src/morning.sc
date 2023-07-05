;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use n091)
(use Str)
(use Array)
(use Motion)
(use File)
(use Game)
(use Actor)
(use System)

(public
	morning 0
)

(local
	local0
	[local1 2]
	local3
	local4
)

(instance morning of Room
	(properties
		picture 60
	)

	(method (init)
		(DisposeScript 205)
		(DisposeScript 250)
		(if (= local0 (== (mod global114 2) 0))
			(= picture 61)
			(train init:)
			(ball init:)
			(mitt init:)
		else
			(doll init:)
			(shoes init:)
		)
		(child init:)
		(deskTop init:)
		(photo init:)
		(book init:)
		(sun init:)
		(super init: &rest)
		(self setScript: sunrise)
		(= global104 0)
		(= global176 1)
	)

	(method (dispose)
		(DisposeScript 64993)
		(super dispose: &rest)
	)
)

(instance sunrise of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(sun setCycle: CT 5 1 self)
			)
			(2
				(gSfx number: (Random 574 577) play: self)
			)
			(3
				(deleteGame doit:)
				(= seconds 2)
			)
			(4
				(child view: (+ 850 global114))
				(childEyes view: (child view:))
				(switch (= temp0 global114)
					(0
						(child posn: 82 123)
						(= local3 82)
						(= local4 123)
						(childEyes posn: 84 106)
					)
					(1
						(child posn: 77 133)
						(= local3 77)
						(= local4 133)
						(childEyes posn: 82 105)
					)
					(2
						(child posn: 77 134)
						(= local3 77)
						(= local4 133)
						(childEyes posn: 81 106)
					)
					(3
						(child posn: 75 133)
						(= local3 78)
						(= local4 138)
						(childEyes posn: 80 105)
					)
					(4
						(child posn: 90 119)
						(= local3 91)
						(= local4 116)
						(childEyes posn: 81 106)
					)
					(5
						(child posn: 73 127)
						(= local3 72)
						(= local4 135)
						(childEyes posn: 83 103)
					)
					(6
						(child posn: 82 129)
						(= local3 78)
						(= local4 133)
						(childEyes posn: 81 102)
					)
					(7
						(child posn: 78 129)
						(= local3 74)
						(= local4 136)
						(childEyes posn: 82 100)
					)
					(8
						(child posn: 81 133)
						(= local3 81)
						(= local4 135)
						(childEyes posn: 83 104)
					)
					(9
						(child posn: 81 128)
						(= local3 75)
						(= local4 136)
						(childEyes posn: 82 100)
					)
					(10
						(child posn: 81 133)
						(= local3 81)
						(= local4 135)
						(childEyes posn: 82 105)
					)
					(11
						(child posn: 90 134)
						(= local3 78)
						(= local4 138)
						(childEyes posn: 83 104)
					)
				)
				(child setLoop: 0)
				(childEyes init: setPri: 140 1 setScript: blink)
				(= cycles 1)
			)
			(5
				(cleanUp doit:)
				(= seconds 6)
			)
			(6
				((global511 plane:) dispose:)
				(global511 dispose:)
				(gCast eachElementDo: #dispose)
				(= global511 0)
				(Palette 2 0 255 0) ; PalIntensity
				(= gOverlays -1)
				(proc0_6)
				(proc0_19 0 320 3)
				(= global176 0)
				(gCurRoom newRoom: 90) ; intro
			)
		)
	)
)

(instance sun of Prop
	(properties
		x 113
		y 54
		cycleSpeed 30
	)

	(method (init)
		(if local0
			(= view 873)
		else
			(= view 893)
		)
		(super init: &rest)
	)
)

(instance book of View
	(properties
		x 276
		y 120
		view 896
		loop 2
	)

	(method (init)
		(if local0
			(= view 876)
			(= x 276)
			(= y 120)
			(= loop 5)
		)
		(super init: &rest)
	)
)

(instance deskTop of View
	(properties
		x 21
		y 145
		view 894
		loop 4
	)

	(method (init)
		(if local0
			(= view 877)
			(= x 20)
			(= y 137)
			(= loop 0)
		else
			(= x 28)
			(= y 155)
		)
		(super init: &rest)
	)
)

(instance train of View
	(properties
		x 220
		y 174
		view 876
		loop 3
		cel 13
	)
)

(instance photo of View
	(properties
		x 234
		y 56
		view 896
		loop 3
	)

	(method (init)
		(if local0
			(= view 877)
			(= x 252)
			(= y 85)
			(= loop 4)
		)
		(super init: &rest)
	)
)

(instance ball of View
	(properties
		x 237
		y 95
		view 876
	)
)

(instance mitt of View
	(properties
		x 242
		y 144
		view 876
		loop 1
	)
)

(instance doll of View
	(properties
		x 244
		y 145
		view 894
	)
)

(instance shoes of View
	(properties
		x 108
		y 182
		view 894
		loop 3
	)
)

(instance child of View
	(properties
		x 76
		y 128
	)

	(method (init &tmp temp0)
		(= loop 1)
		(= view (+ 850 global114))
		(switch (= temp0 global114)
			(0
				(= x 82)
				(= y 123)
			)
			(1
				(= x 77)
				(= y 133)
			)
			(2
				(= x 77)
				(= y 133)
			)
			(3
				(= x 78)
				(= y 138)
			)
			(4
				(= x 91)
				(= y 116)
			)
			(5
				(= x 72)
				(= y 135)
			)
			(6
				(= x 78)
				(= y 133)
			)
			(7
				(= x 74)
				(= y 136)
			)
			(8
				(= x 81)
				(= y 135)
			)
			(9
				(= x 75)
				(= y 136)
			)
			(10
				(= x 81)
				(= y 135)
			)
			(11
				(= x 78)
				(= y 138)
			)
		)
		(super init: &rest)
	)
)

(instance childEyes of Prop
	(properties
		x 83
		y 103
		loop 2
	)

	(method (init)
		(self setPri: 14)
		(= view (child view:))
		(super init: &rest)
		(self setScript: blink)
	)
)

(instance blink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(childEyes cel: 0 setCycle: End self)
			)
			(1
				(childEyes setCycle: Beg)
				(= state -1)
				(= seconds (Random 3 5))
			)
		)
	)
)

(instance deleteGame of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if global522
			(= temp0 (Str new: 12))
			(= temp1 (Str new:))
			(= temp5 (IntArray new: 13))
			(= temp4 (Save 5 (gGame name:) (temp0 data:) (temp5 data:))) ; GetSaveFiles
			(Save 6 (temp1 data:) (gGame name:)) ; MakeSaveCatName
			((= temp2 (File new:)) name: (temp1 data:) open: 2)
			(for ((= temp6 0)) (< temp6 temp4) ((++ temp6))
				(if (!= gMacSaveNumber (temp5 at: temp6))
					(= temp3 (temp5 at: temp6))
					(temp1
						at: 0 (& temp3 $00ff)
						at: 1 (& (>> temp3 $0008) $00ff)
						at: 2 0
					)
					(temp2 write: (temp1 data:) 2)
					(= temp8 (Str new: 36))
					(temp8 copyToFrom: 0 temp0 (* temp6 36) 36)
					(temp2 write: (temp8 data:) 36)
					(temp8 dispose:)
				)
			)
			(temp1 at: 0 255 at: 1 255)
			(temp2 write: (temp1 data:) 2 close: dispose:)
			(Save 7 (temp1 data:) {MG} gMacSaveNumber) ; MakeSaveFileName
			(FileIO fiUNLINK (temp1 data:))
			(= temp8 (Str new: 200))
			(= temp8 (Str format: {%s%d.DTA} gCurSaveDir gMacSaveNumber))
			(FileIO fiUNLINK (temp8 data:))
			(temp8 dispose:)
			(temp1 dispose:)
			(temp5 dispose:)
			(temp0 dispose:)
		)
	)
)

(instance cleanUp of Code
	(properties)

	(method (doit &tmp temp0)
		(for ((= temp0 0)) (< temp0 18) ((++ temp0))
			((gGoals at: temp0)
				egoReturned: 0
				egoTold: 0
				egoSeen: 0
				egoHas: 0
			)
		)
		(for ((= temp0 1)) (<= temp0 44) ((++ temp0))
			(if (!= [global200 temp0] -1)
				(= [global200 temp0] 0)
			)
		)
		(= [global200 34] 57)
		(for ((= temp0 41)) (<= temp0 60) ((++ temp0))
			(if (and (!= temp0 57) (!= temp0 53) (!= temp0 43))
				(proc91_1 temp0)
			)
		)
		(gGame changeScore: 0)
	)
)

