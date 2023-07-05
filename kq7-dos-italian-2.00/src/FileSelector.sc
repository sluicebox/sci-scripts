;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64944)
(include sci.sh)
(use DSelector)
(use Str)

(class FileSelector of DSelector
	(properties
		x 13
		mask 0
		nFiles 0
		sort 1
	)

	(method (init)
		(self readFiles:)
		(super init: &rest)
	)

	(method (readFiles &tmp fileName rc)
		(= fileName (Str new: 13))
		(= nFiles 0)
		(for
			((= rc (FileIO fiFIND_FIRST mask (fileName data:) 0)))
			rc
			((= rc (FileIO fiFIND_NEXT (fileName data:))))
			
			(self setText: (fileName data:))
			(++ nFiles)
		)
		(if sort
			(self sortFileNames:)
		)
		(fileName dispose:)
		(return 1)
	)

	(method (sortFileNames))
)

