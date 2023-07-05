;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 812)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use System)

(public
	eRS 0
)

(procedure (localproc_0)
	(cond
		((< (gEgo sel_1:) 0)
			(gEgo sel_1: (+ 0 (* (gEgo sel_51:) 2)))
		)
		((> (gEgo sel_1:) 319)
			(gEgo sel_1: (- 319 (* (gEgo sel_51:) 2)))
		)
	)
)

(procedure (localproc_1)
	(cond
		((< (gEgo sel_0:) (gCurRoom sel_332:))
			(gEgo sel_0: (+ (gCurRoom sel_332:) (* (gEgo sel_52:) 2)))
		)
		((> (gEgo sel_0:) 189)
			(gEgo sel_0: (- 189 (* (gEgo sel_52:) 2)))
		)
	)
)

(instance controls of Controls
	(properties
		sel_20 {controls}
	)
)

(class SQRoom of Rm
	(properties
		sel_20 {SQRoom}
	)

	(method (sel_110 &tmp temp0 temp1)
		(= sel_40 gCurRoomNum)
		(= sel_335 controls)
		(= gPerspective sel_404)
		(if sel_399
			(self sel_408: sel_399)
		)
		(cond
			((not (gCast sel_122: gEgo)) 0)
			(sel_142 0)
			((OneOf sel_28 11 12 13 14)
				(= temp0
					(+
						1
						(/
							(CelWide
								((User sel_333:) sel_2:)
								((User sel_333:) sel_3:)
								((User sel_333:) sel_4:)
							)
							2
						)
					)
				)
				(= temp1
					(+
						1
						(/
							(CelHigh
								((User sel_333:) sel_2:)
								((User sel_333:) sel_3:)
								((User sel_333:) sel_4:)
							)
							2
						)
					)
				)
				(switch ((User sel_333:) sel_341:)
					(1
						((User sel_333:) sel_0: 188)
					)
					(4
						((User sel_333:) sel_1: (- 319 temp0))
					)
					(3
						((User sel_333:) sel_0: (+ sel_332 temp1))
					)
					(2
						((User sel_333:) sel_1: (+ 0 temp0))
					)
				)
				((User sel_333:) sel_341: 0)
			)
			(else
				(self sel_146: eRS 0 gPrevRoomNum)
			)
		)
	)

	(method (sel_57 &tmp temp0)
		(cond
			(sel_142
				(sel_142 sel_57:)
			)
			((not (gCast sel_122: gEgo)) 0)
			(
				(= temp0
					(switch ((User sel_333:) sel_341:)
						(1 sel_400)
						(2 sel_401)
						(3 sel_402)
						(4 sel_403)
					)
				)
				(self sel_146: lRS 0 temp0)
			)
		)
	)
)

(instance lRS of Script
	(properties
		sel_20 {lRS}
	)

	(method (sel_144 param1 &tmp temp0 temp1)
		(switch (= sel_29 param1)
			(0
				(proc0_2)
				(= temp1
					(CelWide (gEgo sel_2:) (gEgo sel_3:) (gEgo sel_4:))
				)
				(switch sel_141
					((sel_42 sel_400:)
						(gCurRoom sel_390: sel_141)
					)
					((sel_42 sel_402:)
						(= temp0
							(CelHigh
								(gEgo sel_2:)
								(gEgo sel_3:)
								(gEgo sel_4:)
							)
						)
						(if (IsObject (gEgo sel_568:))
							(+=
								temp0
								(CelHigh
									((gEgo sel_568:) sel_2:)
									((gEgo sel_568:) sel_3:)
									((gEgo sel_568:) sel_4:)
								)
							)
						)
						(gEgo
							sel_303:
								Unknown_Class_37
								(gEgo sel_1:)
								(+ 189 temp0)
								self
						)
					)
					((sel_42 sel_401:)
						(gEgo
							sel_303:
								Unknown_Class_37
								(+ 319 temp1)
								(gEgo sel_0:)
								self
						)
					)
					((sel_42 sel_403:)
						(gEgo
							sel_303:
								Unknown_Class_37
								(- 0 temp1)
								(gEgo sel_0:)
								self
						)
					)
				)
			)
			(1
				(gEgo sel_102:)
				(= sel_136 2)
			)
			(2
				(gCurRoom sel_146: 0 sel_390: sel_141)
			)
		)
	)
)

(instance eRS of Script
	(properties
		sel_20 {eRS}
	)

	(method (sel_144 param1 &tmp temp0 temp1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 0)
				(proc0_2)
				(= temp0
					(CelHigh (gEgo sel_2:) (gEgo sel_3:) (gEgo sel_4:))
				)
				(= temp1
					(CelWide (gEgo sel_2:) (gEgo sel_3:) (gEgo sel_4:))
				)
				(switch sel_141
					((sel_42 sel_400:)
						(localproc_0)
						(gEgo
							sel_0: (+ (gCurRoom sel_332:) (gEgo sel_52:))
						)
						(= sel_136 1)
					)
					((sel_42 sel_402:)
						(localproc_0)
						(gEgo
							sel_0: (+ 189 temp0)
							sel_303:
								nBMT
								(gEgo sel_1:)
								(- 189 (* (gEgo sel_52:) 2))
								self
						)
					)
					((sel_42 sel_401:)
						(localproc_1)
						(gEgo
							sel_1: (+ 319 (/ temp1 2))
							sel_303:
								nBMT
								(- 319 (* (gEgo sel_51:) 2))
								(gEgo sel_0:)
								self
						)
					)
					((sel_42 sel_403:)
						(localproc_1)
						(gEgo
							sel_1: (- 0 (/ temp1 2))
							sel_303:
								nBMT
								(+ 0 (* (gEgo sel_51:) 2))
								(gEgo sel_0:)
								self
						)
					)
					(else
						(= sel_136 1)
					)
				)
			)
			(1
				(proc0_3)
				(self sel_111:)
			)
		)
	)
)

(instance nBMT of MoveTo
	(properties
		sel_20 {nBMT}
	)

	(method (sel_57)
		(super sel_57:)
		(if (sel_42 sel_58:)
			(self sel_97:)
		)
	)
)

