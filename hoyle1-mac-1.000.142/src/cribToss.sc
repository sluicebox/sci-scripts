;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 206)
(include sci.sh)
(use Main)
(use room5)

(public
	cribToss 0
)

(instance cribToss of GO
	(properties)

	(method (init param1)
		(= status0 param1)
		(= global173 (status0 findADimCard:))
		(global517 delete: global173)
		(global173 erase: 1)
		(param1 removeCard:)
		(gSndEffect number: (proc0_6 104) playMaybe:)
		((proc5_3)
			init:
				(global173 x:)
				(global173 y:)
				((proc5_8) nextX:)
				((proc5_8) y:)
				[global417 (- global406 1)]
				self
				1
		)
	)

	(method (cue)
		(switch global432
			(1
				((proc5_8) add: global173)
				(global173 loop: 0 faceUp: 0 erase: 0 update:)
				((status0 cardList:) delete: global173)
				(status0 rePosition:)
				(proc0_5)
				(= global173 (status0 findADimCard:))
				(global173 erase: 1 loop: 0)
				(status0 removeCard:)
				(global517 delete: global173)
				(gSndEffect number: (proc0_6 104) playMaybe:)
				((proc5_3)
					init:
						(global173 x:)
						(global173 y:)
						((proc5_8) nextX:)
						((proc5_8) y:)
						[global417 (- global406 1)]
						self
						2
				)
			)
			(2
				((proc5_8) add: global173)
				(global173 loop: 0 faceUp: 0 erase: 0 update:)
				((status0 cardList:) delete: global173)
				(status0 rePosition:)
				(= global432 0)
				(if (== status0 gPlayer0)
					(global435 init: 0)
				)
				(proc0_5)
				(gCardRoom cue:)
			)
		)
	)
)

