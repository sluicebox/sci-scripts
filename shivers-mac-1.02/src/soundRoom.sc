;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 952)
(include sci.sh)
(use Main)
(use n951)
(use Sound)
(use Game)
(use System)

(public
	soundRoom 0
)

(local
	[local0 30]
	local30 = -1
	local31 = -1
	local32
	local33
	local34
	local35
	local36 = 127
	local37
)

(instance soundRoom of Room
	(properties)

	(method (init)
		(super init: &rest)
	)
)

(class ShiversSound of Sound
	(properties
		channelNum 0
		script 0
	)

	(method (init)
		(gTheDoits add: self)
		(super init: &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose: &rest)
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
		(super doit: &rest)
	)

	(method (pause param1)
		(if (== param1 1)
			(= local37 1)
		else
			(= local37 0)
		)
		(super pause: param1 &rest)
	)

	(method (setScript param1)
		(if script
			(script dispose:)
		)
		(if param1
			(param1 init: self)
		)
	)
)

(class SoundManager of Sounds
	(properties)

	(method (play param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(if (== (= temp0 (self isAlreadyPlaying: param1)) 0)
			(if (!= (= temp0 (self getFreeSound:)) 0)
				(proc951_7 param1)
				(temp0 number: param1)
				(temp0 setLoop: param2)
				(temp0 play: param3 param4)
			else
				(= temp1 (self first:))
				(for ((= temp2 0)) temp1 ((++ temp2))
					(= temp0 (KList 8 temp1)) ; NodeValue
					(if
						(and
							(or (== (temp0 vol:) 0) (== (temp0 handle:) 0))
							(!= (temp0 script:) 0)
						)
						(temp0 setVol: 0)
						(temp0 stop:)
						(temp0 client: 0)
						(temp0 number: 0)
					)
					(= temp1 (self next: temp1))
				)
				(if (!= param4 0)
					(param4 cue:)
				)
			)
			(return temp0)
		else
			(if (== (temp0 vol:) 0)
				(temp0 stop:)
			)
			(proc951_7 param1)
			(temp0 number: param1)
			(temp0 setLoop: param2)
			(temp0 play: param3 param4)
			(return temp0)
		)
	)

	(method (isAlreadyPlaying param1 &tmp temp0 temp1)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (and (== (temp1 number:) param1) (!= (temp1 handle:) 0))
				(return temp1)
			)
		)
		(return 0)
	)

	(method (fade param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp2 0)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (and (== (temp1 number:) param1) (!= (temp1 handle:) 0))
				(= temp2 1)
				(cond
					((> (= temp4 (Abs (- (temp1 vol:) param2))) 80)
						(= temp3 2)
					)
					((< temp4 40)
						(= temp3 4)
					)
					(else
						(= temp3 3)
					)
				)
				(if (== temp4 0)
					(temp1 fade: param2 temp3 10 param5 param6)
					(break)
				)
				(temp1 fade: param2 temp3 temp4 param5 param6)
				(break)
			)
		)
		(if (and (== temp2 0) (!= param6 0))
			(param6 cue:)
		)
	)

	(method (setVol param1 param2 &tmp temp0 temp1)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (== (temp1 number:) param1)
				(temp1 setVol: param2)
				(break)
			)
		)
	)

	(method (stop param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (== (temp1 number:) param1)
				(= temp2 (temp1 number:))
				(temp1 setVol: 0)
				(temp1 stop:)
				(temp1 client: 0)
				(temp1 number: 0)
			)
		)
		(proc951_10 temp2)
		(proc951_8 temp2)
	)

	(method (stopAll &tmp temp0 temp1 temp2)
		(= local37 0)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (== 0 (temp1 script:))
				(if (> (= temp2 (temp1 number:)) 0)
					(temp1 setVol: 0)
					(temp1 stop:)
					(temp1 client: 0)
					(temp1 number: 0)
					(proc951_10 temp2)
					(proc951_8 temp2)
				)
			else
				(= local36 0)
				(gSounds interruptChain:)
			)
		)
	)

	(method (getFreeSound &tmp temp0 temp1)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (and (== (temp1 handle:) 0) (== (temp1 script:) 0))
				(break)
			)
		)
		(return (if temp0 temp1 else 0))
	)

	(method (playChain param1 &tmp temp0 temp1 [temp2 2])
		(if (mod argc 2)
			(return 0)
		)
		(return
			(if (>= local31 0)
				(if (== local31 (mod (+ local30 argc) 30))
					(return 0)
				)
				(for ((= temp1 0)) (< temp1 argc) ((+= temp1 2))
					(= [local0 local30] [param1 temp1])
					(= [local0 (+ local30 1)] [param1 (+ temp1 1)])
					(= local30 (mod (+ local30 2) 30))
				)
			else
				(= local31 0)
				(= local30 0)
				(if (== local31 (mod (+ 0 argc) 30))
					(return 0)
				)
				(for ((= temp1 0)) (< temp1 argc) ((+= temp1 2))
					(= [local0 local30] [param1 temp1])
					(= [local0 (+ local30 1)] [param1 (+ temp1 1)])
					(= local30 (mod (+ local30 2) 30))
				)
				(if (!= (= temp0 (gSounds getFreeSound:)) 0)
					(temp0 setScript: sChain)
				)
			)
		)
	)

	(method (stopChain &tmp temp0)
		(= local33 0)
		(= local37 0)
		(= local36 0)
		(= temp0 (mod (+ local31 2) 30))
		(= [local0 temp0] 0)
		(= [local0 (+ local31 1)] 0)
	)

	(method (interruptChain &tmp temp0)
		(= local33 0)
		(= local37 0)
		(sChain state: 1 cue:)
	)

	(method (adjChainVol param1)
		(= local36 param1)
	)

	(method (fadeChain &tmp temp0)
		(= local33 0)
		(= local37 0)
		(sChain state: 0 cue:)
	)
)

(instance sChain of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(if (== [local0 local31] -1)
					(= temp1 (Abs [local0 (+ local31 1)]))
					(= local34 gGameTime)
					(= local35 (* 60 temp1))
					(= local33 1)
					(if (< [local0 (+ local31 1)] 0)
						(= [local0 local30] [local0 local31])
						(= [local0 (+ local30 1)] [local0 (+ local31 1)])
						(= local30 (mod (+ local30 2) 30))
						(= [local0 local31] 0)
						(= [local0 (+ local31 1)] 0)
					)
					(= local31 (mod (+ local31 2) 30))
				)
				(cond
					((or (== local33 1) (== local37 1))
						(if (> (- gGameTime local34) local35)
							(= local33 0)
						)
						(= state -1)
						(= cycles 1)
					)
					((> [local0 local31] 5000)
						(if (and (!= [local0 local31] local32) local32)
							(client setVol: 0)
							(client stop:)
							(client number: 0)
							(proc951_10 local32)
							(proc951_8 local32)
						)
						(= local32 [local0 local31])
						(= temp0 (mod (+ local31 2) 30))
						(if (== [local0 (+ local31 1)] -1)
							(= [local0 local30] [local0 local31])
							(= [local0 (+ local30 1)] -1)
							(= local30 (mod (+ local30 2) 30))
						)
						(= [local0 local31] 0)
						(= [local0 (+ local31 1)] 0)
						(= local31 temp0)
						(proc951_7 local32)
						(proc951_9 local32)
						(client number: local32 setLoop: 0 play: local36 self)
						(= state -1)
					)
					(else
						(= state 1)
						(self cue:)
					)
				)
			)
			(1
				(if local32
					(if local36
						(client fade: 0 5 60 1 self)
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(if local32
					(client setVol: 0)
					(client stop:)
					(client number: 0)
					(proc951_10 local32)
					(proc951_8 local32)
				)
				(for ((= temp2 0)) (< temp2 30) ((+= temp2 1))
					(= [local0 temp2] 0)
				)
				(= local33 0)
				(= local32 0)
				(= local30 -1)
				(= local31 -1)
				(= local36 127)
				(= local37 0)
				(self dispose:)
			)
		)
	)
)

