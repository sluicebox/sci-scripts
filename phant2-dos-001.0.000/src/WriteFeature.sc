;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64948)
(include sci.sh)

(class Obj
	(properties
		scratch 0
		state 0
	)

	(method (new)
		(Clone self)
	)

	(method (init)
		(return self)
	)

	(method (dispose)
		(DisposeClone self)
	)

	(method (doit)
		(return self)
	)

	(method (getSuper)
		super
	)

	(method (info)
		(return -info-)
	)

	(method (isClass)
		(return (& -info- $8000))
	)

	(method (isKindOf param1 &tmp temp0)
		(return
			(or (== param1 self) (and (= temp0 super) (temp0 isKindOf: param1)))
		)
	)

	(method (isMemberOf param1)
		(return
			(or
				(== param1 self)
				(and
					(& (param1 info:) $8000)
					(not (& -info- $8000))
					(== param1 super)
				)
			)
		)
	)

	(method (isScreenItem param1)
		(if argc
			(&= state $fbff)
			(if param1
				(|= state $0400)
			)
		)
		(return (& state $0400))
	)

	(method (needsDoits param1)
		(if argc
			(&= state $feff)
			(if param1
				(|= state $0100)
			)
		)
		(return (& state $0100))
	)

	(method (needsEvents param1)
		(if argc
			(&= state $fdff)
			(if param1
				(|= state $0200)
			)
		)
		(if (and (& state $0200) (not (self respondsTo: #handleEvent)))
			(PrintDebug {%s (%d) cannot receive events} (self name:) self)
			(Empty self)
		)
		(return (& state $0200))
	)

	(method (perform param1)
		(param1 doit: self &rest)
	)

	(method (respondsTo param1)
		(RespondsTo self param1)
	)

	(method (tracksMouse param1)
		(if argc
			(&= state $f7ff)
			(if param1
				(|= state $0800)
			)
		)
		(if (and (& state $0800) (not (self respondsTo: #track)))
			(PrintDebug {%s (%d) cannot track mouse} (self name:) self)
			(Empty self)
		)
		(return (& state $0800))
	)

	(method (yourself)
		(return self)
	)
)

