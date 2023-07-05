;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use System)

(public
	ColorInit 0
)

(instance ColorInit of Code
	(properties)

	(method (init)
		(if (> (Graph 1) 16)
			(= global111 (Palette 3 31 31 31)) ; PalMatch
			(= global112 (Palette 3 63 63 63)) ; PalMatch
			(= global113 (Palette 3 95 95 95)) ; PalMatch
			(= global114 (Palette 3 127 127 127)) ; PalMatch
			(= global115 (Palette 3 159 159 159)) ; PalMatch
			(= global116 (Palette 3 191 191 191)) ; PalMatch
			(= global117 (Palette 3 223 223 223)) ; PalMatch
			(= global118 (Palette 3 151 27 27)) ; PalMatch
			(= global119 (Palette 3 231 103 103)) ; PalMatch
			(= global120 (Palette 3 235 135 135)) ; PalMatch
			(= global121 (Palette 3 187 187 35)) ; PalMatch
			(= global122 (Palette 3 219 219 39)) ; PalMatch
			(= global123 (Palette 3 223 223 71)) ; PalMatch
			(= global124 (Palette 3 27 151 27)) ; PalMatch
			(= global125 (Palette 3 71 223 71)) ; PalMatch
			(= global126 (Palette 3 135 235 135)) ; PalMatch
			(= global127 (Palette 3 23 23 119)) ; PalMatch
			(= global128 (Palette 3 35 35 187)) ; PalMatch
			(= global129 (Palette 3 71 71 223)) ; PalMatch
			(= global130 (Palette 3 135 135 235)) ; PalMatch
			(= global131 (Palette 3 219 39 219)) ; PalMatch
			(= global132 (Palette 3 27 151 151)) ; PalMatch
		else
			(= global111 0)
			(= global128 1)
			(= global124 2)
			(= global132 3)
			(= global118 4)
			(= global131 5)
			(= global122 6)
			(= global112 7)
			(= global113 8)
			(= global129 9)
			(= global125 10)
			(= global133 11)
			(= global119 12)
			(= global134 13)
			(= global123 14)
			(= global117 15)
		)
	)
)

