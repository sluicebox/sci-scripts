;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use SlowTurn)
(use Scaler)
(use StopWalk)
(use Grooper)
(use Ego)
(use Motion)
(use System)

(class GK2Ego of Ego
	(properties
		modNum 0
		signal 30601
		BAD_SELECTOR -1
	)

	(method (BAD_SELECTOR param1 &tmp temp0)
		(if (OneOf gCurRoomNum 700 400 10102 840) ; sqRm, marienRm, starnSeeRm
			(gEgo setLooper: Grooper setPri: -1)
		)
		(if
			(or
				(OneOf
					gCurRoomNum
					700 ; sqRm
					400 ; marienRm
					840 ; starnSeeRm
					10102
					420 ; uberRm
					42201 ; rm4220b
					320 ; leberRm
					3210
					4020
					330 ; vgHouseRm
					10102
					300 ; labRm
					542 ; klingRm
					5211
				)
				(gCurRoom isKindOf: TopicRoom)
			)
			(gEgo view: (if (> argc 0) param1 else view))
			(= temp0 view)
		else
			(if argc
				(gEgo heading: param1)
			)
			(= temp0
				(cond
					((== gEgo GabeEgo)
						(cond
							((gEgo has: 73) 470) ; invPitcher
							(
								(OneOf
									gCurRoomNum
									210 ; farmIntRm
									120 ; srHallRoom
									140 ; srGabeRoom
									130 ; srLibRoom
									150 ; srGerdaRoom
									160 ; srSecretRoom
									170 ; srExtWallRoom
									1403
									2103 ; farmIntRm2
									1100 ; foyerRm
									11002
									1110 ; audRm
									11101
									11120
									11122
									1120 ; resOfficeRm
									1130
									11301
									11302
									11303
									11304
									1140 ; centerHallRm
									11402
									11442
									1150 ; backStageRm
									1160 ; dressingRm
									1170 ; spotRm
									1180 ; basementHallRm
									1185 ; propRm
									1190 ; furnaceRm
									11802
									11803
									11804
									11805
									11806
									11807
									11808
									11809
									11810
									11811
									11812
								)
								450
							)
							((IsFlag 407) 301)
							(else 500)
						)
					)
					((IsFlag 739) 700)
					(
						(OneOf
							gCurRoomNum
							210 ; farmIntRm
							120 ; srHallRoom
							140 ; srGabeRoom
							130 ; srLibRoom
							150 ; srGerdaRoom
							160 ; srSecretRoom
							170 ; srExtWallRoom
							1403
							2103 ; farmIntRm2
							1100 ; foyerRm
							11002
							1110 ; audRm
							11101
							11120
							11122
							1120 ; resOfficeRm
							1130
							11301
							11302
							11303
							11304
							1140 ; centerHallRm
							11402
							11442
							1150 ; backStageRm
							1160 ; dressingRm
							1170 ; spotRm
							1180 ; basementHallRm
							1185 ; propRm
							1190 ; furnaceRm
							11802
							11803
							11804
							11805
							11806
							11807
							11808
							11809
							11810
							11811
							11812
						)
						680
					)
					(else 600)
				)
			)
			(cond
				((gEgo has: 73) ; invPitcher
					(+= temp0 (h2v doit:))
				)
				(
					(or
						(IsFlag 739)
						(OneOf
							gCurRoomNum
							210 ; farmIntRm
							120 ; srHallRoom
							140 ; srGabeRoom
							130 ; srLibRoom
							150 ; srGerdaRoom
							160 ; srSecretRoom
							170 ; srExtWallRoom
							1403
							2103 ; farmIntRm2
							1100 ; foyerRm
							11002
							1110 ; audRm
							11101
							11120
							11122
							1120 ; resOfficeRm
							1130
							11301
							11302
							11303
							11304
							1140 ; centerHallRm
							11402
							11442
							1150 ; backStageRm
							1160 ; dressingRm
							1170 ; spotRm
							1180 ; basementHallRm
							1185 ; propRm
							1190 ; furnaceRm
							11802
							11803
							11804
							11805
							11806
							11807
							11808
							11809
							11810
							11811
							11812
						)
					)
					(SlowTurn view: temp0)
					(gEgo setLooper: SlowTurn)
					(+= temp0 (/ heading 90))
				)
				(else
					(+= temp0 (h2v doit:))
				)
			)
		)
		(gEgo
			view: temp0
			setLoop: -1
			loop: 0
			cel: 0
			setMotion: 0
			setStep: 3 2 0
			setSpeed: 3
			ignoreActors: 1
			setCycle: StopWalk -1
			state: (| (gEgo state:) $0002)
		)
	)

	(method (setHeading param1 param2 param3 &tmp temp0 temp1 temp2)
		(if (>= argc 2)
			(= temp0 param2)
		else
			(= temp0 0)
		)
		(cond
			(
				(or
					(IsFlag 739)
					(OneOf
						gCurRoomNum
						210 ; farmIntRm
						120 ; srHallRoom
						140 ; srGabeRoom
						130 ; srLibRoom
						150 ; srGerdaRoom
						160 ; srSecretRoom
						170 ; srExtWallRoom
						1403
						2103 ; farmIntRm2
						1100 ; foyerRm
						11002
						1110 ; audRm
						11101
						11120
						11122
						1120 ; resOfficeRm
						1130
						11301
						11302
						11303
						11304
						1140 ; centerHallRm
						11402
						11442
						1150 ; backStageRm
						1160 ; dressingRm
						1170 ; spotRm
						1180 ; basementHallRm
						1185 ; propRm
						1190 ; furnaceRm
						11802
						11803
						11804
						11805
						11806
						11807
						11808
						11809
						11810
						11811
						11812
						700 ; sqRm
						400 ; marienRm
						840 ; starnSeeRm
						10102
						420 ; uberRm
						42201 ; rm4220b
						320 ; leberRm
						3210
						4020
						330 ; vgHouseRm
						10102
						300 ; labRm
						542 ; klingRm
						5211
					)
				)
				(super setHeading: param1 param2)
			)
			((IsFlag 407)
				(gGame handsOff:)
				(= temp2 view)
				(= temp1 1)
				(= view (Talisman doit: param1 temp2))
			)
			(else
				(gGame handsOff:)
				(= temp2 view)
				(= temp1 1)
				(cond
					((or (> param1 337) (< param1 23))
						(if (== gEgo GabeEgo)
							(= view (+ 500 (h2v doit:)))
						else
							(= view (+ 600 (h2v doit:)))
						)
						(= heading 0)
					)
					((< 22 param1 68)
						(= heading 45)
						(= view (+ temp2 1))
					)
					((< 67 param1 113)
						(= heading 90)
						(= view (+ temp2 2))
					)
					((< 112 param1 158)
						(= heading 135)
						(= view (+ temp2 3))
					)
					((< 157 param1 203)
						(= heading 180)
						(= view (+ temp2 4))
					)
					((< 202 param1 248)
						(= heading 225)
						(= view (+ temp2 5))
					)
					((< 247 param1 293)
						(= heading 270)
						(= view (+ temp2 6))
					)
					(else
						(= heading 315)
						(= view (+ temp2 7))
					)
				)
			)
		)
		(if
			(not
				(or
					(IsFlag 739)
					(OneOf
						gCurRoomNum
						210 ; farmIntRm
						120 ; srHallRoom
						140 ; srGabeRoom
						130 ; srLibRoom
						150 ; srGerdaRoom
						160 ; srSecretRoom
						170 ; srExtWallRoom
						1403
						2103 ; farmIntRm2
						1100 ; foyerRm
						11002
						1110 ; audRm
						11101
						11120
						11122
						1120 ; resOfficeRm
						1130
						11301
						11302
						11303
						11304
						1140 ; centerHallRm
						11402
						11442
						1150 ; backStageRm
						1160 ; dressingRm
						1170 ; spotRm
						1180 ; basementHallRm
						1185 ; propRm
						1190 ; furnaceRm
						11802
						11803
						11804
						11805
						11806
						11807
						11808
						11809
						11810
						11811
						11812
						700 ; sqRm
						400 ; marienRm
						840 ; starnSeeRm
						10102
						420 ; uberRm
						42201 ; rm4220b
						320 ; leberRm
						3210
						4020
						330 ; vgHouseRm
						10102
						300 ; labRm
						542 ; klingRm
						5211
					)
				)
			)
			(cond
				((not temp1)
					(if temp0
						(temp0 cue:)
					)
				)
				((>= argc 3)
					(self cel: 0 setCycle: CT param3 1 temp0)
				)
				(else
					(self cel: 0 setCycle: End temp0)
				)
			)
			(return heading)
		)
	)

	(method (get param1)
		(if (== BAD_SELECTOR -1)
			(= BAD_SELECTOR (Set new:))
		)
		(BAD_SELECTOR addToFront: (gInventory at: param1))
		(super get: param1 &rest)
	)

	(method (put param1 param2 &tmp temp0)
		(if (self has: param1)
			((= temp0 (gInventory at: param1))
				moveTo: (if (== argc 1) -1 else param2)
			)
			(if (temp0 curItem:)
				(temp0 select: 0)
				(gUser sel_712: 62)
				((gUser sel_715:) sel_712: 62 show: update:)
			)
			(BAD_SELECTOR delete: (gInventory at: param1))
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if (and (gUser input:) (self onMe: event))
			(self doVerb: (event message:))
		else
			(= temp1 (event type:))
			(= temp2 (event message:))
			(if
				(and
					(& temp1 evMOVE)
					(or (not cycler) (cycler isKindOf: Grycler))
				)
				(event claimed: 1)
				(return)
			else
				(super handleEvent: event)
			)
			(event claimed:)
			(return)
		)
	)
)

(class GabeEgo of GK2Ego
	(properties
		noun 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(128 ; invCostume
				(cond
					((IsFlag 781)
						(return 1)
					)
					((== gCurRoomNum 1160) ; dressingRm
						(SetFlag 778)
						(gEgo setSpeed: 3 setHeading: 225 self)
						(return 1)
					)
					(else
						(gMessager say: 3 62 0 0 0 1150) ; "(DARK BUT THOUGHTFUL)I'm not quite ready for my big debut."
					)
				)
			)
			(36 ; invPowder
				(gMessager say: 4 theVerb 0 0 0 1160) ; "(HURRIED)Don't think I have time for a make up job just now."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(Palette 1 (= global249 218)) ; PalLoad
		(self
			put: 85 ; invCostume
			posn: 419 290
			view: 11603
			setLoop: 0 1
			cel: 0
			setScaler: Scaler 111 111 294 289
		)
		(= global145 887)
		(PlayScene 887)
		(= global145 0)
	)
)

(class GraceEgo of GK2Ego
	(properties
		noun 4
	)
)

(instance h2v of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp1 (gEgo heading:))
		(= temp0 0)
		(cond
			((IsFlag 407)
				(cond
					((<= 0 temp1 45))
					((< 44 temp1 135)
						(+= temp0 5)
					)
					((< 134 temp1 225)
						(+= temp0 10)
					)
					((< 224 315)
						(+= temp0 15)
					)
				)
			)
			((gEgo has: 73) ; invPitcher
				(cond
					((< 0 temp1 90))
					((< 89 temp1 157)
						(+= temp0 1)
					)
					((< 156 temp1 226)
						(+= temp0 2)
					)
					((< 225 temp1 295)
						(+= temp0 3)
					)
					((< 294 temp1 360)
						(+= temp0 4)
					)
				)
			)
			((or (> temp1 337) (< temp1 23)))
			((< 22 temp1 68)
				(+= temp0 10)
			)
			((< 67 temp1 113)
				(+= temp0 20)
			)
			((< 112 temp1 158)
				(+= temp0 30)
			)
			((< 157 temp1 203)
				(+= temp0 40)
			)
			((< 202 temp1 248)
				(+= temp0 50)
			)
			((< 247 temp1 293)
				(+= temp0 60)
			)
			(else
				(+= temp0 70)
			)
		)
		(return temp0)
	)
)

(instance Talisman of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(= temp0 param2)
		(cond
			((OneOf param2 301 302 303 304)
				(cond
					((or (> param1 338) (< 0 param1 22))
						(gEgo heading: 0)
					)
					((< 21 param1 90)
						(= temp0 302)
						(gEgo heading: 45)
					)
					((< 89 param1 270)
						(= temp0 303)
						(gEgo heading: 180)
					)
					((< 269 param1 339)
						(= temp0 304)
						(gEgo heading: 315)
					)
				)
			)
			((OneOf param2 306 307 308 309)
				(cond
					((< 68 param1 112)
						(gEgo heading: 90)
					)
					((< 111 param1 180)
						(= temp0 307)
						(gEgo heading: 135)
					)
					((< 179 param1 360)
						(= temp0 308)
						(gEgo heading: 270)
					)
					((< 0 param1 69)
						(= temp0 309)
						(gEgo heading: 45)
					)
				)
			)
			((OneOf param2 311 312 313 314)
				(cond
					((< 158 param1 202)
						(gEgo heading: 180)
					)
					((< 90 param1 159)
						(= temp0 314)
						(gEgo heading: 225)
					)
					((or (> param1 269) (< param1 91))
						(= temp0 313)
						(gEgo heading: 0)
					)
					((< 201 param1 270)
						(= temp0 312)
						(gEgo heading: 135)
					)
				)
			)
			((OneOf param2 316 317 318 319)
				(cond
					((< param1 181)
						(= temp0 318)
						(gEgo heading: 90)
					)
					((< 247 param1 293)
						(gEgo heading: 270)
					)
					((< 292 param1 360)
						(= temp0 317)
						(gEgo heading: 315)
					)
					((< 180 param1 248)
						(= temp0 319)
						(gEgo heading: 225)
					)
				)
			)
		)
		(return temp0)
	)
)

