;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use domino1)
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
		(gSong play: 805)
		(= local0 (gSystemWindow color:))
		(= local1 (gSystemWindow back:))
		(gSystemWindow color: 16 back: 21)
		(if (> temp160 1)
			(Format @temp60 101 0) ; "Hands"
		else
			(Format @temp60 101 1) ; "Hand"
		)
		(Format @temp161 101 2 (global118 playerName:) (global119 playerName:)) ; "SCORECARD  %=10s %=9s --------------------------------"
		(StrCat
			@temp161
			(Format ; "%-15s %=3d    %=3d"
				@temp80
				101
				3
				(Format @temp120 101 4 temp160 @temp60) ; "After %d %s"
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
						(gChar1 say: (Random 18 20))
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
						(gChar1 say: (Random 15 17))
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
						(gChar1 say: (Random 21 23))
					)
					(++ global141)
				)
			)
			(StrCat
				@temp161
				(Format @temp0 101 3 (Format @temp120 101 5) global125 global126) ; "%-15s %=3d    %=3d", "This Hand"
			)
		)
		(StrCat
			@temp161
			(Format @temp80 101 3 (Format @temp120 101 6) global139 global140) ; "%-15s %=3d    %=3d", "Hands Won"
		)
		(if global141
			(StrCat @temp161 (Format @temp80 101 7 global141 global141)) ; "Hands Tied   %=3d    %=3d"
		)
		(Print @temp161 33 500 179 gDoAbsCode)
		(gSystemWindow color: local0 back: local1)
		(gSong fade:)
	else
		(gChar1 say: (Random 33 35))
	)
)

(instance dominoes_opt of File
	(properties
		name {dominoes.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 8])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(Format ; "%d%d%d%d%d%3d"
								@temp0
								101
								8
								global130
								global132
								(BoneYard showAtEnd:)
								(BoneYard limit:)
								(BoneYard number:)
								global148
							)
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(self read: @temp20 1)
				(= global130 (ReadNumber @temp20))
				(self read: @temp20 1)
				(= global132 (ReadNumber @temp20))
				(self read: @temp20 1)
				(BoneYard showAtEnd: (ReadNumber @temp20))
				(self read: @temp20 1)
				(BoneYard limit: (ReadNumber @temp20 4))
				(self read: @temp20 1)
				(BoneYard number: (ReadNumber @temp20 4))
				(self read: @temp20 1)
				(= global148 (ReadNumber @temp20 3))
				(if (and (!= (BoneYard limit:) 0) (!= (BoneYard limit:) 2))
					(BoneYard limit: 0)
				)
				(if (and (!= (BoneYard number:) 5) (!= (BoneYard number:) 7))
					(BoneYard number: 7)
				)
				(if (or (mod global148 100) (< global148 100) (> global148 500))
					(= global148 100)
				)
				(self close:)
				(return 0)
			)
			(else
				(= global130 1)
				(= global132 1)
				(BoneYard showAtEnd: 0)
				(BoneYard limit: 0)
				(BoneYard number: 7)
				(= global148 100)
				(return 0)
			)
		)
	)
)

