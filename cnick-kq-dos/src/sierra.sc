;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	sierra 0
)

(local
	local0
	local1
	local2 = 120
	local3 = 40
	local4
	local5
)

(instance sierra of Rm
	(properties
		sel_20 {sierra}
		sel_368 900
		sel_28 10
	)

	(method (sel_110)
		(super sel_110:)
		(= local4 0)
		(= local5 0)
		(gGame sel_365: 12)
		(Load rsVIEW 950)
		(self sel_145: introScript)
		(gSong sel_39: 1)
		(gSong sel_165: 1)
	)

	(method (sel_277)
		(gCurRoom sel_358: 975)
	)

	(method (sel_57)
		(super sel_57:)
		(cond
			((and (== (gSong sel_157:) 20) (not local4))
				(= local4 1)
				(sparkle sel_282: 223 165 sel_110:)
			)
			((and (== (gSong sel_157:) 30) (not local5))
				(= local5 1)
				(sparkle sel_282: 75 165 sel_110:)
			)
			((and (== (gSong sel_157:) -1) (= local5 1))
				(introScript sel_144:)
			)
		)
		(Palette palANIMATE 95 218 -1)
		(if (fred sel_56:)
			(if (== (++ local1) 1)
				(= local0 (+ 180 (GetTime)))
			)
			(if (u< local0 (GetTime))
				(cond
					((< local1 local3)
						(= gHowFast 0)
					)
					((< local1 local2)
						(= gHowFast 1)
					)
					(else
						(= gHowFast 2)
					)
				)
				(fred sel_296: 0)
			)
		)
	)
)

(instance introScript of Script
	(properties
		sel_20 {introScript}
	)

	(method (sel_143 param1)
		(switch (= sel_29 param1)
			(0
				(while (u> (GetTime) 65344)
				)
				(fred
					sel_2: 950
					sel_165: 8
					sel_15: 0
					sel_282: 5 8
					sel_306: 1 1
					sel_296: MoveTo 300 8
					sel_63: 0
					sel_110:
				)
				(= local1 0)
			)
			(1
				(gSong sel_165: -1)
				(gCurRoom sel_358: 975)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		sel_20 {sparkle}
		sel_2 950
	)

	(method (sel_110)
		(self sel_165: 2 sel_4: 0 sel_287: sel_63: 14 sel_153: End)
		(super sel_110:)
	)
)

(instance fred of Actor
	(properties
		sel_20 {fred}
	)
)

