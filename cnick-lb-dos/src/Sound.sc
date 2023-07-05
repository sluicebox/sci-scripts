;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 989)
(include sci.sh)
(use Main)
(use System)

(class Sound of Obj
	(properties
		sel_20 {Sound}
		sel_41 0
		sel_90 0
		sel_99 0
		sel_40 0
		sel_94 127
		sel_60 0
		sel_3 1
		sel_14 0
		sel_157 0
		sel_89 0
		sel_91 0
		sel_92 0
		sel_93 0
		sel_42 0
		sel_158 0
	)

	(method (sel_109 param1)
		((super sel_109:) sel_158: (if argc param1 else 0) sel_117:)
	)

	(method (sel_110)
		(= sel_157 (= sel_14 0))
		(gSounds sel_118: self)
		(DoSound sndINIT self)
	)

	(method (sel_39 param1 &tmp temp0)
		(= temp0 argc)
		(if (and argc (IsObject [param1 (- argc 1)]))
			(= sel_42 [param1 (= temp0 (- argc 1))])
		else
			(= sel_42 0)
		)
		(self sel_110:)
		(if (not sel_3)
			(= sel_3 1)
		)
		(if temp0
			(= sel_94 param1)
		else
			(= sel_94 127)
		)
		(DoSound sndPLAY self 0)
	)

	(method (sel_159)
		(if sel_90
			(DoSound sndUPDATE_CUES self)
			(DoSound sndSTOP self)
		)
	)

	(method (sel_160 param1)
		(if (not argc)
			(= param1 1)
		)
		(DoSound sndPAUSE (if (self sel_115: Sound) self else 0) param1)
	)

	(method (sel_161 param1)
		(if (not argc)
			(= param1 1)
		)
		(DoSound sndSET_HOLD self param1)
	)

	(method (sel_125)
		(DoSound sndSET_HOLD self 0)
	)

	(method (sel_162 param1 param2 param3 param4 &tmp temp0)
		(= temp0 argc)
		(if (and argc (IsObject [param1 (- argc 1)]))
			(= sel_42 [param1 (= temp0 (- argc 1))])
		)
		(if temp0
			(DoSound sndFADE self param1 param2 param3 param4)
		else
			(DoSound sndFADE self 0 10 10 1)
		)
	)

	(method (sel_163 param1)
		(if (not argc)
			(= param1 1)
		)
		(DoSound 13 self param1) ; Mute
	)

	(method (sel_164 param1)
		(DoSound sndSET_VOLUME self param1)
	)

	(method (sel_63 param1)
		(DoSound sndSET_PRIORITY self param1)
	)

	(method (sel_165 param1)
		(DoSound sndSET_LOOP self param1)
	)

	(method (sel_166 param1 param2 param3 param4)
		(if (<= 1 param1 15)
			(if (< param2 128)
				(DoSound sndSEND_MIDI self param1 176 param2 param3)
			else
				(DoSound sndSEND_MIDI self param1 param2 param3 param4)
			)
		)
	)

	(method (sel_167)
		(if sel_90
			(DoSound sndUPDATE_CUES self)
		)
		(if sel_14
			(= sel_157 sel_14)
			(= sel_14 0)
			(if (IsObject sel_42)
				(sel_42 sel_144: self)
			)
		)
	)

	(method (sel_168 param1)
		(if (or (not sel_158) (== sel_158 param1))
			(self sel_111:)
		)
	)

	(method (sel_111)
		(gSounds sel_81: self)
		(if sel_41
			(DoSound sndDISPOSE self)
			(= sel_41 0)
		)
		(super sel_111:)
	)

	(method (sel_169 param1 &tmp temp0)
		(= temp0 argc)
		(if (and argc (IsObject [param1 (- argc 1)]))
			(= sel_42 [param1 (= temp0 (- argc 1))])
		else
			(= sel_42 0)
		)
		(self sel_110:)
		(if (not sel_3)
			(= sel_3 1)
		)
		(if temp0
			(= sel_94 param1)
		else
			(= sel_94 127)
		)
		(DoSound sndPLAY self 1)
	)

	(method (sel_143)
		(DoSound sndUPDATE self)
	)
)

