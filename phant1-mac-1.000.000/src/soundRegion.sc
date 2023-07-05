;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Str)
(use Array)
(use Sound)
(use Game)
(use System)

(public
	soundRegion 0
)

(class SoundManager of Script
	(properties
		soundArray 0
		mySound 0
		curSound 0
	)

	(method (save param1 &tmp temp0 temp1)
		(= temp0 (Str newWith: 10 {}))
		(if soundArray
			(for ((= temp1 0)) (!= (soundArray at: temp1) -1) ((++ temp1))
				(proc0_7 temp0 0 (soundArray at: temp1))
				(param1 write: temp0 2)
			)
			(proc0_7 temp0 0 -1)
			(param1 write: temp0 2)
		else
			(proc0_7 temp0 0 -1)
			(param1 write: temp0 2)
		)
		(proc0_7 temp0 0 curSound)
		(param1 write: temp0 2)
		(proc0_7 temp0 0 scratch)
		(param1 write: temp0 2)
		(if (and script (script scratch:))
			(proc0_7 temp0 0 ((script scratch:) number:))
			(param1 write: temp0 2)
			(proc0_7 temp0 0 ((script scratch:) loop:))
			(param1 write: temp0 2)
			(proc0_7 temp0 0 ((script scratch:) vol:))
			(param1 write: temp0 2)
		else
			(proc0_7 temp0 0 0)
			(param1 write: temp0 2)
			(proc0_7 temp0 0 0)
			(param1 write: temp0 2)
			(proc0_7 temp0 0 0)
			(param1 write: temp0 2)
		)
		(temp0 dispose:)
	)

	(method (restore param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= caller 0)
		(= temp0 (Str newWith: 10 {}))
		(= soundArray (IntArray new: 1))
		(for ((= temp1 0)) (param1 read: temp0 2) ((++ temp1))
			(if (and (== temp1 0) (== (proc0_8 temp0 0) -1))
				(soundArray dispose:)
				(= soundArray 0)
				(break)
			)
			(soundArray at: temp1 (proc0_8 temp0 0))
			(if (== (soundArray at: temp1) -1)
				(break)
			)
		)
		(param1 read: temp0 2)
		(= curSound (proc0_8 temp0 0))
		(param1 read: temp0 2)
		(= scratch (proc0_8 temp0 0))
		(param1 read: temp0 2)
		(= temp2 (proc0_8 temp0 0))
		(param1 read: temp0 2)
		(= temp3 (proc0_8 temp0 0))
		(param1 read: temp0 2)
		(= temp4 (proc0_8 temp0 0))
		(if temp2
			(self pause: temp2 0 temp3)
			(self setVol: temp4)
		)
		(if temp1
			(self play: -1)
		)
		(temp0 dispose:)
	)

	(method (init))

	(method (play param1 &tmp temp0 temp1 temp2)
		(cond
			((not argc)
				(return)
			)
			((and (== argc 1) (== param1 -1))
				(if (not mySound)
					(= mySound (Sound new:))
					(mySound flags: 4)
				)
				(mySound client: 0 stop:)
				(mySound
					number: (soundArray at: curSound)
					loop: -1
					owner: self
					setVol: 0
				)
				(if (not script)
					(mySound
						play: self
						fade: (if scratch scratch else 127) 4 2 0
					)
				)
			)
			(else
				(if soundArray
					(if (!= (mySound number:) param1)
						(mySound stop:)
					)
					(soundArray dispose:)
				)
				(= soundArray (IntArray new: 1))
				(if (not mySound)
					(= mySound (Sound new:))
					(mySound flags: 4)
				)
				(= temp2 1)
				(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
					(soundArray at: temp0 [param1 temp0])
					(if (== (mySound number:) [param1 temp0])
						(= temp2 0)
						(= curSound temp0)
					)
				)
				(soundArray at: temp0 -1)
				(if script
					(= curSound 0)
					(return)
				)
				(cond
					(temp2
						(if (not (mySound handle:))
							(= temp1 (mySound vol:))
							(mySound
								number: (soundArray at: (= curSound 0))
								loop: -1
								owner: self
								setVol: temp1
								play: self
							)
						else
							(mySound dispose:)
							(= temp1 (mySound vol:))
							(= mySound (Sound new:))
							(mySound flags: 4)
							(mySound
								number: (soundArray at: (= curSound 0))
								loop: -1
								owner: self
								setVol: temp1
								play: self
							)
						)
					)
					((not (mySound handle:))
						(= temp1 (mySound vol:))
						(mySound
							number: (soundArray at: (= curSound 0))
							loop: -1
							owner: self
							setVol: temp1
							play: self
						)
					)
				)
			)
		)
	)

	(method (stop param1)
		(cond
			((and argc param1)
				(if script
					(script caller: 0)
					(script dispose:)
					(= script 0)
				)
				(if mySound
					(mySound client: 0)
					(mySound dispose:)
					(= mySound 0)
				)
				(if soundArray
					(soundArray dispose:)
					(= soundArray 0)
				)
			)
			(argc
				(cond
					(script
						(script caller: 0)
						(script dispose:)
						(= script 0)
					)
					(mySound
						(mySound dispose:)
					)
				)
			)
			(script
				(script dispose:)
			)
			(else
				(self cue:)
			)
		)
	)

	(method (fade param1 param2 param3 param4 param5 &tmp temp0)
		(if (and (> argc 4) param5)
			(= temp0 param5)
		else
			(= temp0 0)
		)
		(cond
			((and mySound (mySound handle:))
				(if (or (and (> argc 3) param4) (== param1 0))
					(mySound stop:)
				else
					(mySound setVol: param1)
				)
			)
			(temp0
				(temp0 cue:)
			)
		)
	)

	(method (setVol param1)
		(if (> argc 1)
			(if (and script (script scratch:))
				((script scratch:) setVol: param1)
			)
		else
			(= scratch param1)
			(if mySound
				(mySound setVol: param1)
			)
		)
	)

	(method (cue &tmp temp0)
		(if (and next (pausedSounds contains: next))
			(next dispose:)
			(= next 0)
		)
		(if caller
			(caller cue:)
			(= caller 0)
		)
		(if (not mySound)
			(return)
		)
		(if soundArray
			(if (== (soundArray at: (++ curSound)) -1)
				(= curSound 0)
			)
			(if
				(and
					(mySound handle:)
					(== (mySound number:) (soundArray at: curSound))
				)
				(mySound client: self fade: (if scratch scratch else 127) 4 2 0)
			)
		)
	)

	(method (pause param1 param2 param3)
		(if script
			(script caller: 0 dispose: (not argc))
		)
		(if caller
			(caller cue:)
			(= caller 0)
		)
		(if mySound
			(mySound client: 0)
			(if (mySound handle:)
				(if (and next (pausedSounds contains: next))
					(next dispose:)
					(= next 0)
				)
				(= next (pauseSound init: self mySound))
			)
		)
		(if (and (> argc 1) param2)
			(= caller param2)
		)
		(cond
			((not argc))
			((> argc 2)
				((= script (SMpauseScr new:)) init: self self param1 param3)
			)
			(else
				((= script (SMpauseScr new:)) init: self self param1)
			)
		)
		(if curSound
			(-- curSound)
		)
	)

	(method (endPause)
		(cond
			(script
				(cond
					((and (script next:) (script scratch:))
						(if (pausedSounds contains: (script next:))
							((script next:) dispose:)
						)
						(script next: 0)
						(if (not ((script scratch:) handle:))
							(script caller: self dispose:)
							(= script 0)
						else
							(script state: 2 caller: self)
							((script scratch:)
								pause: 0
								fade: (if scratch scratch else 127) 4 2 0 script
							)
						)
					)
					((not argc)
						(script caller: self dispose:)
						(= script 0)
					)
				)
			)
			(mySound
				(self cue:)
			)
		)
	)
)

(instance pausedSounds of Set
	(properties)
)

(instance pauseSound of Script
	(properties)

	(method (init param1 param2 &tmp temp0)
		(= temp0 (self new:))
		(temp0 client: param1 register: param2)
		(pausedSounds add: temp0)
		(param2 scratch: (param2 vol:) fade: 0 4 2 0 temp0)
		(return temp0)
	)

	(method (cue)
		(register pause: 1)
		(self dispose:)
	)

	(method (dispose)
		(pausedSounds delete: self)
		(DisposeClone self)
	)
)

(instance deadSound of Script
	(properties)

	(method (init param1 &tmp temp0)
		(= temp0 (self new:))
		(temp0 register: param1)
		(param1 setLoop: -1 fade: 0 4 2 1 temp0)
	)

	(method (cue)
		(register dispose:)
		(DisposeClone self)
	)
)

(instance SMpauseScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(if (!= register -1)
			(if (> argc 3)
				((= scratch (Sound new:))
					number: register
					owner: global114
					flags: 4
					play:
				)
				(scratch setLoop: -1)
			else
				((= scratch (Sound new:))
					number: register
					owner: global114
					flags: 4
					play: self
				)
				(scratch setLoop: 1)
			)
		else
			(= scratch 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(self dispose:)
			)
			(2)
			(3
				(if scratch
					(cond
						((not (scratch handle:))
							(self dispose:)
						)
						((!= (scratch loop:) -1)
							(scratch client: self)
							(= state 0)
						)
					)
				else
					(self dispose:)
				)
			)
		)
	)

	(method (dispose param1)
		(if (and argc param1 scratch (scratch handle:))
			(if (and next (pausedSounds contains: next))
				(next dispose:)
				(= next 0)
			)
			(= next (pauseSound init: self scratch))
		else
			(if scratch
				(if (scratch handle:)
					(deadSound init: scratch)
				else
					(scratch dispose:)
				)
				(= scratch 0)
			)
			(super dispose:)
		)
	)
)

(instance soundRegion of Rgn
	(properties)

	(method (doVerb theVerb &tmp temp0)
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

	(method (init)
		(if (not script)
			(= script (SoundManager new:))
			(script client: self)
			(= global114 script)
		)
		(= keep 1)
	)
)

