;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 209)
(include sci.sh)
(use Main)
(use Rm62)
(use Interface)
(use Save)
(use System)

(public
	getWhatRelic 0
)

(local
	[local0 120]
	[local120 20]
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp1 (StrLen param1))
	(if (not (>= 12 temp1 3))
		(return 0)
	)
	(= temp2 0)
	(= temp3 0)
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(= temp4 (StrAt param1 temp0))
		(if (and (not temp3) (or (>= 122 temp4 97) (>= 90 temp4 65)))
			(= temp3 1)
			(if (>= 122 temp4 97)
				(StrAt param1 temp0 (+ temp4 -32))
			)
		)
		(cond
			((== temp4 32)
				(= temp2 (+ temp0 1))
			)
			(temp2
				(return 0)
			)
		)
	)
	(if (== temp2 temp1)
		(return 0)
	)
	(return (or (> temp2 2) (not temp2)))
)

(instance getWhatRelic of Script
	(properties)

	(method (changeState newState &tmp [temp0 20] temp20)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj noDispose: 1)
				(proc62_1 209 0) ; "Gladly will I sell you relic. But first you must tell me -- what is the name of the saint whose relic you wish to buy?"
				(= cycles 4)
			)
			(1
				(= temp0 0)
				(repeat
					(= temp20 (Event new:))
					(if (temp20 type:)
						(temp20 dispose:)
					else
						(break)
					)
				)
				(temp20 dispose:)
				(GetInput @temp0 12 {Enter saint name:} 35 SysWindow 67 -1 100)
				(if (localproc_0 @temp0)
					(StrCpy @local120 @temp0)
					(self changeState: 2)
				else
					(self changeState: 5)
				)
			)
			(2
				(gTObj endTalk:)
				(gTObj talkCue: self)
				(proc62_1 (Format @local0 209 1 @local120 @local120)) ; "Saint %s! Yes, I do have a relic of Saint %s. Normally, 3 dinar, on sale today for 2 dinars. But I like you. You have an honest face. So for you, only 1 dinar!"
			)
			(3
				(= seconds 1)
			)
			(4
				(= global151 1)
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 209)
			)
			(5
				(gTObj endTalk:)
				(gTObj talkCue: self)
				(proc62_1 209 2) ; "No, no. I must have the name of the saint whose relic you wish to buy. Nothing else will do. Think it over. If you are still interested in buying a relic, just say so."
			)
			(6
				(= global151 0)
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 209)
			)
		)
	)
)

