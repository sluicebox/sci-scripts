;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm46 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance streetLight of Prop
	(properties)
)

(instance redLight1 of Prop
	(properties)
)

(instance redLight2 of Prop
	(properties)
)

(instance blueLight1 of Prop ; UNUSED
	(properties)
)

(instance blueLight2 of Prop ; UNUSED
	(properties)
)

(instance building of Act
	(properties)
)

(instance farBuildings of Act
	(properties)
)

(instance jim1 of View
	(properties)
)

(instance jim2 of View
	(properties)
)

(instance jim3 of View
	(properties)
)

(instance jimb1 of View
	(properties)
)

(instance jimb2 of View
	(properties)
)

(instance rm46 of Rm
	(properties
		picture 46
	)

	(method (incClientPos)
		(User sel_424: 0 sel_436: 0)
		(= local0 0)
		(= local1 0)
		(= local3 337)
		(= local4 76)
		(Load rsSOUND 1)
		(Load rsVIEW 310)
		(Load rsVIEW 924)
		(Load rsVIEW 925)
		(super incClientPos:)
		(streetLight
			nsLeft: 310
			nsRight: 2
			sel_354: 298 122
			hide: 15
			incClientPos:
		)
		(redLight1
			nsLeft: 310
			nsRight: 1
			sel_354: 276 149
			hide: 12
			incClientPos:
		)
		(redLight2
			nsLeft: 310
			nsRight: 1
			sel_354: 293 149
			hide: 12
			incClientPos:
		)
		(building
			nsLeft: 310
			sel_360: 3
			sel_312: 0
			sel_354: 340 80
			hide: 1
			incClientPos:
			cursor: 0
			sel_362:
			sel_340: MoveTo 250 105
		)
		(farBuildings
			nsLeft: 310
			sel_360: 4
			sel_312: 0
			sel_354: local3 local4
			hide: 0
			incClientPos:
		)
		(jim1
			nsLeft: 924
			nsRight: 0
			lsLeft: 0
			sel_354: 26 108
			hide: 14
			incClientPos:
			sel_362:
		)
		(jim2
			nsLeft: 924
			nsRight: 0
			lsLeft: 1
			sel_354: 56 108
			hide: 14
			incClientPos:
			sel_362:
		)
		(jim3
			nsLeft: 924
			nsRight: 0
			lsLeft: 2
			sel_354: 80 108
			hide: 14
			incClientPos:
			sel_362:
			sel_366:
		)
		(jimb1
			nsLeft: 925
			nsRight: 0
			lsLeft: 0
			sel_354: 125 108
			hide: 14
			incClientPos:
			sel_362:
			sel_366:
		)
		(jimb2
			nsLeft: 925
			nsRight: 0
			lsLeft: 1
			sel_354: 176 108
			hide: 14
			incClientPos:
			sel_362:
			sel_366:
		)
		(Animate (gCast yStep:) 0)
		(self sel_370: rm46Script)
	)
)

(instance rm46Script of Script
	(properties)

	(method (set)
		(if (== local0 0)
			(self echo: 0)
		)
		(if (and (== local0 1) (== local4 100))
			(gCurRoom sel_446: 47)
		)
		(cond
			((and (== local1 3) (= local2 0))
				(-= local3 1)
				(farBuildings sel_354: local3 local4)
				(= local1 0)
				(+= local2 1)
			)
			((and (== local1 3) (= local2 10))
				(-= local3 1)
				(+= local4 1)
				(farBuildings sel_354: local3 local4)
				(= local1 0)
				(= local2 0)
			)
			(else
				(+= local1 1)
			)
		)
		(if (and (== (building nsTop:) 250) (== (building cel:) 105))
			(self echo: 1)
		)
	)

	(method (canControl param1)
		(if (== (param1 done:) 4)
			(gCurRoom sel_446: 47)
		)
	)

	(method (echo param1)
		(switch (= state param1)
			(0
				(streetLight setSpeed: Fwd)
				(redLight1 setSpeed: Fwd)
				(redLight2 setSpeed: Fwd)
				(Display 46 0 dsCOORD 10 115) ; "Name: Jim Walls"
				(Display 46 1 dsCOORD 10 125) ; "Weight: 200 lbs"
				(Display 46 2 dsCOORD 10 135) ; "Height: 5'10""
				(Display 46 3 dsCOORD 10 145) ; "Hair: Light Brown"
				(Display 46 4 dsCOORD 10 155) ; "Eyes: Green"
				(Display 46 5 dsCOORD 10 165) ; "Wanted: For excessive verbosity"
				(Display 46 6 dsCOORD 150 115) ; "Alias: B.B.Walls"
				(Display 46 7 dsCOORD 150 125) ; "MO: Author and"
				(Display 46 8 dsCOORD 175 135) ; "designer of"
				(Display 46 9 dsCOORD 175 145) ; "Police Quest II"
				(= local0 1)
			)
			(1
				(building sel_354: 340 80)
				(self prompt:)
			)
			(2
				(building sel_340: MoveTo 250 105)
			)
		)
	)
)

