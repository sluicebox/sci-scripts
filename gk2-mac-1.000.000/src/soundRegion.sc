;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Array)
(use Print)
(use Game)
(use System)

(public
	soundRegion 0
)

(class SoundManager of Script
	(properties
		soundArray 0
		curSound 0
		initialSound 0
		cleanUp 0
		curSoundNum 0
		rndBeg 5
		rndEnd 10
		pauseAll 0
	)

	(method (init))

	(method (setRandom param1 param2)
		(if (== param1 -1)
			(= rndBeg 5)
			(= rndEnd 10)
		else
			(= rndBeg param1)
			(= rndEnd param2)
		)
	)

	(method (lockDac param1 param2)
		(if (ResCheck rsAUDIO param1)
			(Lock rsAUDIO param1 param2)
		)
		(if (ResCheck 140 param1) ; WAVE
			(Lock 140 param1 param2) ; WAVE
		)
		(if (ResCheck rsSOUND param1)
			(Lock rsSOUND param1 param2)
		)
	)

	(method (play param1 &tmp temp0)
		(if (not argc)
			(Prints {WARNING: 0 args passed to SoundManager!})
			(return)
		else
			(= cleanUp 0)
			(if soundArray
				(soundArray dispose:)
			)
			(= soundArray (IntArray new: 1))
			(= initialSound [param1 0])
			(for ((= temp0 1)) (< temp0 argc) ((++ temp0))
				(soundArray at: (- temp0 1) [param1 temp0])
			)
			(soundArray at: (- temp0 1) -1)
			(if initialSound
				(= curSoundNum initialSound)
				(self lockDac: curSoundNum 1)
				(gGk2Music number: initialSound loop: 1 play: self)
			else
				(= curSoundNum (soundArray at: (= curSound 0)))
				(self lockDac: curSoundNum 1)
				(gGk2Music number: curSoundNum loop: 1 play: self)
			)
		)
	)

	(method (cue &tmp temp0)
		(cond
			((not soundArray) 0)
			(cleanUp
				(self lockDac: curSoundNum 0)
				(soundArray dispose:)
				(= cleanUp (= soundArray 0))
			)
			(initialSound
				(self lockDac: curSoundNum 0)
				(= initialSound 0)
				(self setDelay:)
			)
			(scratch
				(= scratch 0)
				(self lockDac: curSoundNum 0)
				(for
					((= temp0 curSound))
					(== temp0 curSound)
					((= temp0 (Random 0 (- (soundArray size:) 2))))
				)
				(= curSound temp0)
				(= curSoundNum (soundArray at: curSound))
				(self lockDac: curSoundNum 1)
				(gGk2Music number: curSoundNum loop: 1 play: self)
			)
			(else
				(self setDelay:)
			)
		)
	)

	(method (setDelay)
		(if (!= rndBeg 0)
			(= seconds (Random rndBeg rndEnd))
			(= scratch 1)
		else
			(= scratch 1)
			(self cue:)
		)
	)

	(method (fade param1 param2 param3 param4 param5 &tmp temp0)
		(if (and (> argc 4) param5)
			(= temp0 param5)
		else
			(= temp0 0)
		)
		(cond
			((gGk2Music handle:)
				(if temp0
					(gGk2Music fade: param1 param2 param3 param4 temp0)
				else
					(gGk2Music fade: param1 param2 param3 param4)
				)
			)
			(temp0
				(temp0 cue:)
			)
		)
	)

	(method (stop)
		(gGk2Music stop:)
		(self cleanUp: 1 cue:)
	)
)

(instance soundRegion of Rgn
	(properties)

	(method (init)
		(if (not script)
			(= script SoundManager)
			(script client: self)
			(= gSoundManager script)
		)
		(= keep 1)
	)

	(method (doVerb theVerb)
		(if (and (== modNum -1) (== (= modNum (gCurRoom modNum:)) -1))
			(= modNum gCurRoomNum)
		)
		(return
			(if
				(and
					(ResCheck rsMESSAGE modNum)
					(Message msgGET modNum noun theVerb case 1)
				)
				(gMessager say: noun theVerb case 0 0 modNum)
				1
			else
				0
			)
		)
	)
)

