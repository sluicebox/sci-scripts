;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use unknown_100_4)
(use Interface)
(use File)

(public
	proc101_0 0
	dominoes_opt 1
)

(local
	local0
	local1
)

(procedure (proc101_0 &tmp [temp0 60] [temp60 20] [temp80 40] [temp120 40] temp160 [temp161 200])
	(= temp160 global129)
	(if (not global117)
		(-- temp160)
	)
	(if (> temp160 0)
		(gSong sel_39: 805)
		(= local0 (gSystemWindow sel_25:))
		(= local1 (gSystemWindow sel_26:))
		(gSystemWindow sel_25: 16 sel_26: 21)
		(if (> temp160 1)
			(Format @temp60 199 8) ; "Hands"
		else
			(Format @temp60 199 9) ; "Hand"
		)
		(Format @temp161 199 10 (global118 sel_510:) {Laura}) ; "SCORECARD  %=10s %=9s --------------------------------"
		(StrCat
			@temp161
			(Format ; "%-15s %=3d    %=3d"
				@temp80
				199
				11
				(Format @temp120 199 12 temp160 @temp60) ; "After %d %s"
				global123
				global124
			)
		)
		(if (!= global133 -1)
			(cond
				(global125
					(if
						(and
							(< global125 global148)
							(< global126 global148)
							(not (Random 0 3))
						)
						(gUnknown_0_2 sel_446: (Random 18 20))
					)
					(++ global139)
				)
				(global126
					(if
						(and
							(< global125 global148)
							(< global126 global148)
							(not (Random 0 3))
						)
						(gUnknown_0_2 sel_446: (Random 15 17))
					)
					(++ global140)
				)
				(else
					(if
						(and
							(< global125 global148)
							(< global126 global148)
							(not (Random 0 3))
						)
						(gUnknown_0_2 sel_446: (Random 21 23))
					)
					(++ global141)
				)
			)
			(StrCat
				@temp161
				(Format ; "%-15s %=3d    %=3d"
					@temp0
					199
					13
					(Format @temp120 199 14) ; "This Hand"
					global125
					global126
				)
			)
		)
		(StrCat
			@temp161
			(Format @temp80 199 15 (Format @temp120 199 16) global139 global140) ; "%-15s %=3d    %=3d", "Hands Won"
		)
		(if global141
			(StrCat @temp161 (Format @temp80 199 17 global141 global141)) ; "Hands Tied   %=3d    %=3d"
		)
		(Print @temp161 30 500 182 gUnknown_0_25)
		(gSystemWindow sel_25: local0 sel_26: local1)
		(gSong sel_162:)
	else
		(gUnknown_0_2 sel_446: (Random 33 35))
	)
)

(instance dominoes_opt of File
	(properties
		sel_20 {dominoes.opt}
	)

	(method (sel_57 param1 &tmp [temp0 20] [temp20 8])
		(cond
			((and argc (== param1 3))
				(if (self sel_183: 2)
					(self
						sel_328:
							(Format ; "%d%d%d%d%d%3d"
								@temp0
								199
								18
								global130
								global132
								(Class_100_2 sel_643:)
								(Class_100_2 sel_642:)
								(Class_100_2 sel_40:)
								global148
							)
						sel_332:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self sel_183: 1)
				(self sel_330: @temp20 1)
				(= global130 (ReadNumber @temp20))
				(self sel_330: @temp20 1)
				(= global132 (ReadNumber @temp20))
				(self sel_330: @temp20 1)
				(Class_100_2 sel_643: (ReadNumber @temp20))
				(self sel_330: @temp20 1)
				(Class_100_2 sel_642: (ReadNumber @temp20 4))
				(self sel_330: @temp20 1)
				(Class_100_2 sel_40: (ReadNumber @temp20 4))
				(self sel_330: @temp20 1)
				(= global148 (ReadNumber @temp20 3))
				(if
					(and
						(!= (Class_100_2 sel_642:) 0)
						(!= (Class_100_2 sel_642:) 2)
					)
					(Class_100_2 sel_642: 0)
				)
				(if
					(and
						(!= (Class_100_2 sel_40:) 5)
						(!= (Class_100_2 sel_40:) 7)
					)
					(Class_100_2 sel_40: 7)
				)
				(if (or (mod global148 100) (< global148 100) (> global148 500))
					(= global148 100)
				)
				(self sel_332:)
				(return 0)
			)
			(else
				(= global130 1)
				(= global132 1)
				(Class_100_2 sel_643: 0)
				(Class_100_2 sel_642: 0)
				(Class_100_2 sel_40: 7)
				(= global148 100)
				(return 0)
			)
		)
	)
)

