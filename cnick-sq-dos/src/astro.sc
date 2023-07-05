;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Blk)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	astro 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	[local14 6] = [0 5 4 3 2 1]
	[local20 6] = [0 9 8 7 6 5]
	local26 = 50
	local27
	local28 = 4
	local29 = 100
)

(instance theSound of Sound
	(properties
		sel_20 {theSound}
	)
)

(instance winged of Sound
	(properties
		sel_20 {winged}
		sel_40 56
	)
)

(instance eggSquirt of Sound
	(properties
		sel_20 {eggSquirt}
		sel_40 122
	)
)

(instance eggFall of Sound
	(properties
		sel_20 {eggFall}
		sel_40 131
	)
)

(instance eggSplatting of Sound
	(properties
		sel_20 {eggSplatting}
		sel_40 147
	)
)

(instance gunshot of Sound
	(properties
		sel_20 {gunshot}
		sel_40 144
	)
)

(instance cornPicker of Sound
	(properties
		sel_20 {cornPicker}
		sel_40 146
	)
)

(instance dogBarking of Sound
	(properties
		sel_20 {dogBarking}
		sel_40 827
	)
)

(instance astro of SQRoom
	(properties
		sel_20 {astro}
	)

	(method (sel_110)
		(Load rsVIEW 290)
		(Load rsPIC 291)
		(LoadMany rsSOUND 55 140 56 122 131 147 144 146 827)
		(if (!= gPrevRoomNum 200)
			(self sel_408: 290 sel_409: 291 10 sel_146: startScript)
		else
			(self sel_408: 1 sel_146: startScript)
		)
		(super sel_110:)
		(= sel_399 290)
		(= local11 (gGame sel_395:))
		(musicToggle sel_110:)
		(gMouseDownHandler sel_118: gCast gFeatures)
		(= local27 ((gTheIconBar sel_64: 2) sel_33:))
		(gTheIconBar
			sel_178:
			sel_225: 0 1 3 4 5 6 7
			sel_214: ((gTheIconBar sel_64: 2) sel_33: gNormalCursor sel_117:)
		)
		(gGame sel_198: ((gTheIconBar sel_214:) sel_33:))
	)

	(method (sel_111)
		(gSounds sel_119: 168)
		(gMouseDownHandler sel_81: gCast gFeatures)
		((gTheIconBar sel_64: 2) sel_33: local27)
		(gTheIconBar sel_178:)
		(gTheIconBar sel_178: sel_225: 0 1 2 3 4 5 6 7)
		(gGame sel_395: local11)
		(DisposeScript 949)
		(super sel_111:)
	)

	(method (sel_292 param1)
		(switch param1
			(1 0)
			(2 0)
			(4 0)
		)
	)

	(method (sel_57 &tmp temp0)
		(Wait local28)
		(super sel_57:)
		(Palette palANIMATE 48 55 1)
		(cond
			((gCurRoom sel_142:))
			((not (-- local26))
				(= local26 50)
				(if (not (gCast sel_122: henHouseRight))
					(if (not (gCast sel_122: rock))
						(rock sel_110:)
					)
					(if (not (gCast sel_122: grass))
						(grass sel_110:)
					)
				)
			)
		)
		(cond
			((gCurRoom sel_142:))
			(local3
				(if (and (not (-- local3)) local4)
					((cornStalk sel_109:) sel_110:)
					(= local3 3)
					(-- local4)
				)
			)
			(
				(and
					(>= local8 250)
					(not (gCast sel_122: crazedFarmer))
					(not (gCast sel_122: windMill))
					(not (gCast sel_122: weasel))
					(not (gCast sel_122: rabidDog))
					(not (gCast sel_122: astroChicken2))
				)
				(henHouseLeft sel_110:)
				(henHouseRight sel_110:)
				(astroChicken2
					sel_3: (astroChicken sel_3:)
					sel_1: (astroChicken sel_1:)
					sel_0: (astroChicken sel_0:)
					sel_110:
					sel_162: Fwd
				)
				(astroChicken sel_102: sel_111:)
				(gCurRoom sel_146: doHenHouse)
			)
			(
				(or
					(gCast sel_122: hill)
					(gCast sel_122: crazedFarmer)
					(gCast sel_122: windMill)
					(gCast sel_122: weasel)
					(gCast sel_122: chickenWire)
					(gCast sel_122: henHouseRight)
				))
			((or (gSounds sel_122: winged) (gSounds sel_122: 55)))
			((<= (= temp0 (Random 1 100)) 15)
				(hill sel_110:)
				(switch (Random 0 2)
					(0
						(if (not (gCast sel_122: rabidDog))
							(rabidDog sel_110:)
						)
					)
					(1
						(if (not (gCast sel_122: crazedFarmer))
							(crazedFarmer sel_110:)
						)
					)
				)
			)
			((<= temp0 30)
				(crazedFarmer sel_110:)
			)
			((<= temp0 40)
				(windMill sel_110:)
			)
			((<= temp0 65)
				(if
					(and
						(< (astroChicken sel_595:) 5)
						(not (gCast sel_122: cornStalk))
					)
					(= local3 3)
					(= local4 (Random 4 9))
				)
			)
			((<= temp0 80)
				(weasel sel_110:)
			)
			(
				(and
					(<= temp0 85)
					(not (astroChicken sel_3:))
					(not (gCast sel_122: chickenWire))
				)
				(chickenWire sel_110:)
			)
			((not (gCast sel_122: rabidDog))
				(rabidDog sel_110:)
			)
		)
	)

	(method (sel_390)
		(if local0
			(proc0_12 local0)
		)
		(if local1
			(proc0_12 local1)
		)
		(if local9
			(proc0_12 local9)
		)
		(if local10
			(proc0_12 local10)
		)
		(if local12
			(proc0_12 local12)
		)
		(if local13
			(proc0_12 local13)
		)
		(super sel_390: &rest)
	)
)

(class astroChicken of Actor
	(properties
		sel_20 {astroChicken}
		sel_2 290
		sel_14 2048
		sel_596 3
		sel_595 10
		sel_597 0
	)

	(method (sel_110 &tmp [temp0 5])
		(gLongSong sel_40: 54 sel_3: -1 sel_94: 127 sel_177:)
		(super sel_110:)
		(self
			sel_207:
			sel_1: 160
			sel_0: 40
			sel_595: 10
			sel_3: 0
			sel_597: 0
			sel_599:
			sel_600:
		)
		(astroIndicator sel_110: sel_308:)
		(gDirectionHandler sel_129: self)
		(gKeyDownHandler sel_129: self)
		(if local12
			(proc0_12 local12)
		)
		(if local13
			(proc0_12 local13)
		)
		(= local12 (proc0_12 {Eggs:} 64 150 178 25 global136))
		(= local13 (proc0_12 {Score:} 64 240 178 25 global136))
		(if local1
			(proc0_12 local1)
		)
		(= local1
			(proc0_12 (Format @temp0 {%d} local8) 64 275 178 25 global136 67 25)
		)
	)

	(method (sel_111)
		(gDirectionHandler sel_81: self)
		(gKeyDownHandler sel_81: self)
		(super sel_111:)
	)

	(method (sel_133 param1 &tmp temp0 temp1)
		(cond
			((& (param1 sel_31:) $0040)
				(param1 sel_73: 1)
				(switch (param1 sel_37:)
					(7
						(astroChicken sel_303: MoveTo 0 (astroChicken sel_0:))
					)
					(3
						(astroChicken sel_303: MoveTo 320 (astroChicken sel_0:))
					)
					(1
						(astroChicken sel_303: MoveTo (astroChicken sel_1:) 0)
					)
					(5
						(astroChicken sel_303: MoveTo (astroChicken sel_1:) 190)
					)
				)
			)
			((== (param1 sel_31:) 1)
				(param1 sel_73: 1)
				(if (== (param1 sel_61:) 3)
					(if
						(and
							sel_595
							(not (gCast sel_122: egg))
							(astroChicken sel_301:)
						)
						(eggSquirt sel_39:)
						(egg sel_110:)
						(-- sel_595)
						(self sel_599:)
					)
				else
					(= temp0 (Min 213 (Max 87 (param1 sel_1:))))
					(astroChicken sel_303: MoveTo temp0 (param1 sel_0:))
				)
			)
			((== (param1 sel_31:) 4)
				(param1 sel_73: 1)
				(cond
					((< (astroChicken sel_53:) 3)
						(= local28 4)
					)
					(
						(and
							(> (astroChicken sel_53:) 3)
							(< (astroChicken sel_53:) 6)
						)
						(= local28 6)
					)
				)
				(if
					(and
						(OneOf (param1 sel_37:) 45 95)
						(< (astroChicken sel_53:) 6)
					)
					(astroChicken
						sel_236: (+ (astroChicken sel_236:) 1)
						sel_53: (+ (astroChicken sel_53:) 1)
					)
				)
				(if
					(and
						(OneOf (param1 sel_37:) 43 61)
						(> (astroChicken sel_53:) 0)
					)
					(astroChicken
						sel_236: (- (astroChicken sel_236:) 1)
						sel_53: (- (astroChicken sel_53:) 1)
					)
				)
				(switch (param1 sel_37:)
					(15616
						(Printf ; "MoveSpeed: %d -- CycleSpeed: %d"
							290
							0
							(astroChicken sel_53:)
							(astroChicken sel_236:)
						)
					)
					(13
						(if
							(and
								sel_595
								(not (gCast sel_122: egg))
								(astroChicken sel_301:)
							)
							(eggSquirt sel_39:)
							(egg sel_110:)
							(-- sel_595)
							(self sel_599:)
						)
					)
					(else
						(param1 sel_73: 0)
						(super sel_133: param1)
					)
				)
			)
		)
	)

	(method (sel_598)
		(if (not (-- sel_596))
			(Print 290 1) ; "Game Over"
			(if gModelessDialog
				(gModelessDialog sel_111:)
			)
			(proc0_21)
		else
			(winged sel_111:)
			(gCast sel_119: 111)
			(gCurRoom sel_408: 290)
			(self sel_110:)
			(astroIndicator sel_4: (- (astroIndicator sel_4:) 1) sel_110:)
		)
	)

	(method (sel_599 &tmp [temp0 5])
		(if local0
			(proc0_12 local0)
		)
		(= local0
			(proc0_12 (Format @temp0 {%d} sel_595) 64 180 178 25 global136 67 25)
		)
	)

	(method (sel_600 &tmp [temp0 5])
		(if local1
			(proc0_12 local1)
		)
		(= local1
			(proc0_12 (Format @temp0 {%d} local8) 64 275 178 25 global136 67 25)
		)
	)

	(method (sel_601 &tmp temp0)
		(++ sel_595)
		(= temp0 (Max 0 (- sel_595 8)))
		(self sel_599:)
	)

	(method (sel_602 param1 &tmp [temp0 41] temp41)
		(if (> param1 1)
			(+= local8 param1)
		else
			(= temp41 (/ sel_0 20))
			(if param1
				(+= local8 [local14 temp41])
			else
				(+= local8 [local20 temp41])
			)
		)
		(self sel_600:)
	)
)

(class ScrollActor of Actor
	(properties
		sel_20 {ScrollActor}
		sel_2 290
		sel_60 12
		sel_14 2064
		sel_603 9
		sel_604 0
		sel_605 0
	)

	(method (sel_110)
		(= sel_9 (= sel_8 (= sel_7 (= sel_6 0))))
		(super sel_110:)
		(= sel_7 -1)
		(= sel_1 350)
	)

	(method (sel_57)
		(super sel_57:)
		(cond
			((< (-= sel_1 sel_603) -50)
				(self sel_111:)
			)
			((and (astroChicken sel_301:) (self sel_209: astroChicken))
				(self sel_606:)
			)
			((and (gCast sel_122: egg) (self sel_209: egg))
				(self sel_607:)
			)
		)
	)

	(method (sel_606)
		(if sel_604
			(gLongSong sel_168:)
			(eggSplatting sel_168:)
			(theSound sel_40: sel_605 sel_3: 1 sel_39: self)
			(astroChicken sel_102:)
			(self sel_155: sel_604 sel_156: 0 sel_236: 2 sel_162: End)
		)
	)

	(method (sel_607))

	(method (sel_145)
		(astroChicken sel_598:)
	)
)

(instance hill of ScrollActor
	(properties
		sel_20 {hill}
		sel_0 143
		sel_3 11
		sel_4 4
	)

	(method (sel_110)
		(self sel_156: (Random 4 5))
		(super sel_110:)
	)
)

(instance grass of ScrollActor
	(properties
		sel_20 {grass}
		sel_3 11
		sel_4 6
	)

	(method (sel_110)
		(super sel_110:)
		(= sel_603 11)
		(+= sel_1 (Random 0 150))
		(= sel_0 155)
		(self sel_63: 14)
	)
)

(instance rock of ScrollActor
	(properties
		sel_20 {rock}
		sel_0 143
		sel_3 11
		sel_4 7
		sel_60 13
	)

	(method (sel_110)
		(super sel_110:)
		(= sel_603 11)
		(+= sel_1 (Random 0 150))
		(= sel_0 155)
		(self sel_63: 14)
	)
)

(instance weasel of ScrollActor
	(properties
		sel_20 {weasel}
		sel_15 0
		sel_604 7
		sel_605 55
	)

	(method (sel_110)
		(= sel_603 13)
		(= sel_3 4)
		(= sel_0 (astroChicken sel_0:))
		(super sel_110:)
		(self sel_162: Fwd)
	)

	(method (sel_209 param1 &tmp temp0)
		(= temp0 0)
		(cond
			(
				(not
					(and
						(<= sel_7 (param1 sel_1:) (- sel_9 15))
						(<= (- sel_6 5) (param1 sel_0:) (+ sel_8 10))
					)
				))
			((== sel_603 9))
			((astroChicken sel_3:)
				(astroChicken sel_597: (- (astroChicken sel_597:) 1) sel_602: 5)
				(weasel sel_603: 9)
				(if (not (astroChicken sel_597:))
					(astroChicken sel_155: 0)
				)
			)
			(else
				(= temp0 1)
			)
		)
		(return temp0)
	)
)

(instance crazedFarmer of ScrollActor
	(properties
		sel_20 {crazedFarmer}
		sel_3 5
	)

	(method (sel_110)
		(= sel_3 5)
		(if (gCast sel_122: hill)
			(= sel_0 130)
		else
			(= sel_0 143)
		)
		(super sel_110:)
		(= local2 10)
	)

	(method (sel_607)
		(astroChicken sel_602: 0)
		(eggFall sel_168:)
		(eggSplatting sel_39:)
		(egg sel_102: sel_111:)
		(self sel_155: 8 sel_156: 0 sel_162: End)
	)

	(method (sel_57)
		(super sel_57:)
		(cond
			((== sel_3 8))
			((and (not sel_237) (astroChicken sel_301:) (not (-- local2)))
				(self sel_162: End self)
			)
		)
		(if
			(and
				(== sel_3 5)
				(<= sel_1 (astroChicken sel_1:))
				(astroChicken sel_301:)
			)
			(self sel_155: 6)
		)
	)

	(method (sel_145)
		(gunshot sel_39:)
		((buckShot sel_109:) sel_110:)
		(self sel_162: Beg)
		(= local2 (Random 5 10))
	)

	(method (sel_209 param1)
		(return
			(and
				(<= sel_7 (param1 sel_1:) sel_9)
				(<= sel_6 (param1 sel_0:) (- sel_8 15))
			)
		)
	)
)

(instance windMill of ScrollActor
	(properties
		sel_20 {windMill}
		sel_3 11
	)

	(method (sel_110)
		(super sel_110:)
		(= sel_0 105)
		(self sel_63: 13)
		(windMillBlade sel_110:)
	)
)

(instance windMillBlade of ScrollActor
	(properties
		sel_20 {windMillBlade}
		sel_604 13
		sel_605 55
	)

	(method (sel_110)
		(= sel_3 12)
		(super sel_110:)
		(= sel_0 105)
		(self sel_63: 14 sel_162: Fwd)
	)
)

(instance cornStalk of ScrollActor
	(properties
		sel_20 {cornStalk}
		sel_0 120
		sel_3 11
		sel_4 1
	)

	(method (sel_110)
		(super sel_110:)
		((cornTop sel_109:) sel_110:)
	)
)

(instance cornTop of ScrollActor
	(properties
		sel_20 {cornTop}
		sel_0 120
		sel_3 11
		sel_4 2
	)

	(method (sel_606)
		(cornPicker sel_39:)
		(astroChicken sel_601:)
		(self sel_102:)
	)

	(method (sel_209 param1)
		(return
			(and
				(<= (- sel_7 1) (param1 sel_1:) (+ sel_9 2))
				(<= (- sel_6 10) (param1 sel_0:) (+ sel_8 15))
			)
		)
	)
)

(instance rabidDog of ScrollActor
	(properties
		sel_20 {rabidDog}
		sel_604 10
		sel_605 140
	)

	(method (sel_110)
		(= sel_3 15)
		(= sel_236 (= sel_4 0))
		(if (gCast sel_122: hill)
			(= sel_0 130)
		else
			(= sel_0 143)
		)
		(super sel_110:)
	)

	(method (sel_606)
		(if (and (== sel_3 15) (not sel_237))
			(dogBarking sel_39:)
			(if (< (- sel_0 (astroChicken sel_0:)) 50)
				(super sel_606:)
			else
				(self sel_162: End)
			)
		)
	)

	(method (sel_607)
		(astroChicken sel_602: 1)
		(eggFall sel_168:)
		(eggSplatting sel_39:)
		(egg sel_102: sel_111:)
		(self sel_155: 9 sel_156: 0 sel_162: End)
	)

	(method (sel_209 param1)
		(if (== param1 astroChicken)
			(return
				(and
					(<= (- sel_7 15) (param1 sel_1:) (- sel_9 25))
					(<= (- sel_6 75) (param1 sel_0:) sel_8)
				)
			)
		else
			(super sel_209: param1 &rest)
		)
	)
)

(instance chickenWire of ScrollActor
	(properties
		sel_20 {chickenWire}
		sel_0 150
		sel_3 11
		sel_4 13
	)

	(method (sel_110)
		(self sel_156: 13)
		(super sel_110:)
	)

	(method (sel_606)
		(cornPicker sel_39:)
		(astroChicken sel_155: 1 sel_597: 3)
		(self sel_156: 14)
	)
)

(instance theCage of Cage
	(properties
		sel_20 {theCage}
		sel_194 20
		sel_195 75
		sel_196 118
		sel_197 225
	)
)

(instance astroIndicator of View
	(properties
		sel_20 {astroIndicator}
		sel_1 16
		sel_0 185
		sel_2 290
		sel_3 11
		sel_4 12
		sel_60 15
		sel_14 16
	)
)

(instance egg of Actor
	(properties
		sel_20 {egg}
		sel_2 290
		sel_60 13
		sel_14 2064
	)

	(method (sel_110)
		(super sel_110:)
		(eggFall sel_39:)
		(= sel_1 (astroChicken sel_1:))
		(= sel_0 (+ (astroChicken sel_0:) 5))
		(= local6 7)
		(= local7 1)
		(= local5 2)
		(self sel_155: 2 sel_162: Fwd)
	)

	(method (sel_57)
		(super sel_57:)
		(self sel_153: (+ sel_1 local6) (+ sel_0 local7))
		(if (not (-- local5))
			(-- local6)
			(++ local7)
			(if (>= sel_0 150)
				((eggSplat sel_109:) sel_110:)
				(self sel_111:)
			else
				(= local5 2)
			)
		)
	)
)

(instance eggSplat of Actor
	(properties
		sel_20 {eggSplat}
		sel_0 155
		sel_2 290
		sel_3 3
		sel_60 12
		sel_14 2064
		sel_51 9
	)

	(method (sel_110)
		(super sel_110:)
		(eggFall sel_168:)
		(eggSplatting sel_39:)
		(= sel_1 (egg sel_1:))
		(self sel_162: End sel_303: MoveTo -5 sel_0 self)
	)

	(method (sel_145)
		(self sel_111:)
	)
)

(instance buckShot of Actor
	(properties
		sel_20 {buckShot}
		sel_52 9
		sel_2 290
		sel_3 11
		sel_4 3
		sel_14 30720
		sel_15 0
	)

	(method (sel_110)
		(super sel_110:)
		(= local2 0)
		(self
			sel_153: (crazedFarmer sel_1:) 108
			sel_303: MoveTo (crazedFarmer sel_1:) -18 self
		)
	)

	(method (sel_57)
		(super sel_57:)
		(if (and (astroChicken sel_301:) (astroChicken sel_209: self))
			(gLongSong sel_168:)
			(eggFall sel_168:)
			(winged sel_39: astroChicken)
			(astroChicken sel_102: sel_598:)
			(self sel_111:)
		)
	)

	(method (sel_145)
		(self sel_111:)
	)
)

(instance henHouseLeft of Actor
	(properties
		sel_20 {henHouseLeft}
		sel_1 500
		sel_0 145
		sel_2 290
		sel_3 11
		sel_4 8
		sel_60 3
		sel_14 22544
	)

	(method (sel_57)
		(super sel_57: &rest)
		(if (> sel_1 169)
			(-= sel_1 9)
		else
			(= sel_1 160)
		)
	)
)

(instance henHouseRight of Actor
	(properties
		sel_20 {henHouseRight}
		sel_1 500
		sel_0 145
		sel_2 290
		sel_3 11
		sel_4 9
		sel_60 12
		sel_14 22544
	)

	(method (sel_57)
		(super sel_57: &rest)
		(if (> sel_1 169)
			(-= sel_1 9)
		else
			(= sel_1 160)
		)
	)
)

(instance backok of Prop
	(properties
		sel_20 {backok}
		sel_1 100
		sel_0 90
		sel_2 290
		sel_3 14
	)
)

(instance astroChicken2 of Actor
	(properties
		sel_20 {astroChicken2}
		sel_2 290
		sel_14 2048
	)
)

(instance musicToggle of Feature
	(properties
		sel_20 {musicToggle}
		sel_1 82
		sel_0 177
		sel_6 176
		sel_7 81
		sel_8 188
		sel_9 117
	)

	(method (sel_110)
		(super sel_110:)
		(gMouseDownHandler sel_129: self)
		(gKeyDownHandler sel_129: self)
	)

	(method (sel_111)
		(gMouseDownHandler sel_81: self)
		(gKeyDownHandler sel_81: self)
		(super sel_111:)
	)

	(method (sel_133 param1)
		(if
			(and
				(or
					(== (param1 sel_31:) 1)
					(and (== (param1 sel_31:) 4) (== (param1 sel_37:) 19))
				)
				(self sel_209: param1)
			)
			(if (gGame sel_395:)
				(gGame sel_395: 0)
			else
				(gGame sel_395: local11)
			)
			(param1 sel_73: 1)
		)
	)
)

(instance startScript of Script
	(properties
		sel_20 {startScript}
	)

	(method (sel_57 &tmp temp0 temp1)
		(super sel_57: &rest)
		(if (< sel_141 40)
			(++ sel_141)
		else
			(self sel_145:)
		)
		(if (== sel_29 0)
			(= temp1 ((= temp0 (Event sel_109:)) sel_31:))
			(if (OneOf temp1 1 4)
				(= sel_137 0)
				(= sel_136 1)
			)
			(temp0 sel_111:)
		)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(if (!= gPrevRoomNum 200)
					(= local9
						(proc0_12
							{"Flight of the Pullet."}
							64
							10
							127
							25
							global129
							26
							global132
						)
					)
				)
			)
			(1
				(proc0_12 local9)
				(gCurRoom sel_408: 290)
				(astroChicken
					sel_110:
					sel_162: Fwd
					sel_325:
					sel_596: 3
					sel_599:
					sel_600:
				)
				(astroChicken sel_236: 3 sel_53: 3)
				((astroChicken sel_316:) sel_118: theCage)
				(sel_42 sel_146: 0)
			)
		)
	)
)

(instance doHenHouse of Script
	(properties
		sel_20 {doHenHouse}
	)

	(method (sel_57 &tmp temp0 temp1)
		(super sel_57: &rest)
		(if (== sel_29 5)
			(= temp1 ((= temp0 (Event sel_109:)) sel_31:))
			(if (OneOf temp1 1 4)
				(= sel_137 0)
				(= sel_136 1)
			)
			(temp0 sel_111:)
		)
	)

	(method (sel_144 param1 &tmp temp0 [temp1 50])
		(switch (= sel_29 param1)
			(0
				(+= local8 (* (astroChicken sel_595:) 5))
				(if local1
					(proc0_12 local1)
				)
				(= local1
					(proc0_12
						(Format @temp1 {%d} local8)
						64
						275
						178
						25
						global136
						67
						25
					)
				)
				(astroChicken2 sel_303: MoveTo 100 100 self)
			)
			(1
				(astroChicken2 sel_303: MoveTo 104 129 self)
			)
			(2
				(astroChicken2 sel_63: 11 sel_303: MoveTo 174 129 self)
			)
			(3
				(backok sel_110: sel_162: End)
				(= sel_136 20)
			)
			(4
				(backok sel_111:)
				(= sel_136 2)
			)
			(5
				(= local9
					(proc0_12
						{Congratulations, in achieving the coveted rank of "Corn-Wheezer," you have won the Pullet Surprise!}
						64
						0
						20
						25
						global129
						26
						global140
						27
						1
						67
						319
					)
				)
				(= local10
					(proc0_12
						(Format
							@temp1
							{5 X %d eggs = %d bonus points\n\nMega-Hi Score: %d}
							(astroChicken sel_595:)
							(* 5 (astroChicken sel_595:))
							local8
						)
						64
						0
						65
						25
						global129
						26
						global136
						27
						1
					)
				)
				(Print 290 1) ; "Game Over"
				(= sel_136 1)
			)
			(6
				(proc0_12 local9)
				(proc0_12 local10)
				(proc0_21)
			)
		)
	)
)

